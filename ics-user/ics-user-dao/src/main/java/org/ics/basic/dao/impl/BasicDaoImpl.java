package org.ics.basic.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.ics.basic.dao.IBasicDao;
import org.ics.user.basic.AbstractPagedQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class BasicDaoImpl<T> extends HibernateTemplate implements IBasicDao<T> {
	@Override
	/**
	 * 给HibernateTemplate 注入 sessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		super.setSessionFactory(sessionFactory);
	}

	public void saveEntity(T entity) {
		this.persist(entity);
	}

	public Object updateEntity(T entity) {
		return this.merge(entity);
	}

	public void deleteEntity(Class<T> entityClass, Object... entityIds) {
		//this.delete(entity);
	}

	public Object findEntity(Class<T> entityClass, Serializable entityId) {
		// TODO Auto-generated method stub
		return this.load(entityClass, entityId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getScrollData(Class<T> entityClass,
			AbstractPagedQuery<T> pagedQuery) {
		
		String entityName = this.getEntityName(entityClass);// 获取实体名称

		Map<String, Object> queryParams = new HashMap<String, Object>();
		pagedQuery.getQueryParams(queryParams);// 获取分页参数

		StringBuilder sql = new StringBuilder();
		sql.append("select o from " + entityName + " o where (1=1)");

		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from " + entityName + " o where (1=1)");
		// 拼接sql参数
		for (Entry<String, Object> entry : queryParams.entrySet()) {
			sql.append(" and (o.").append(entry.getKey()).append("=:").append(entry.getKey())
					.append(")");
			countSql.append(" and (o.").append(entry.getKey()).append("=:").append(entry.getKey())
			.append(")");
		}
		logger.info(sql);
		Query query = this.getSession().createQuery(sql.toString());

		logger.info(countSql.toString());
		Query countQuery = this.getSession().createQuery(countSql.toString());

		// 设置查询参数
		for (Entry<String, Object> entry : queryParams.entrySet()) {
			query.setParameter(entry.getKey(), queryParams.get(entry.getKey()));
			countQuery.setParameter(entry.getKey(),
					queryParams.get(entry.getKey()));
		}
		Long totalRecord = (Long) countQuery.uniqueResult();
		pagedQuery.setTotalRecord(totalRecord.intValue());// 设置总记录数
		pagedQuery.setTotalPage();// 设置总页数
		
		pagedQuery.setStartRecord();// 设置起始记录
		pagedQuery.setEndRecord();// 设置结束记录
		query.setFirstResult(pagedQuery.getStartRecord());
		query.setMaxResults(pagedQuery.getPageSize());
		// 设置查询结果集
		pagedQuery.setQueryResults(query.list());
	}

	/**
	 * 获取实体类的名称
	 * 
	 * @param <T>
	 * @param entityClass
	 *            实体类
	 * @return String 实体类名称
	 */
	@SuppressWarnings("hiding")
	private <T> String getEntityName(Class<T> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (null != entity.name() && !"".equals(entity.name())) {
			entityName = entity.name();
		}
		return entityName;
	}

}
