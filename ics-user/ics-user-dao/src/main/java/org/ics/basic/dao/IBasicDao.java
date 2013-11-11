package org.ics.basic.dao;

import java.io.Serializable;

import org.ics.user.basic.AbstractPagedQuery;

public interface IBasicDao<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void saveEntity(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	T updateEntity(T entity);

	/**
	 * 删除实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param entityIds
	 */
	void deleteEntity(Class<T> entityClass, Object... entityIds);
	
	/**
	 * 删除实体
	 * @param t
	 */
	void deleteEntity(T t);
	
	/**
	 * 获取实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param entityId
	 * @return
	 */
	T findEntity(Class<T> entityClass, Serializable entityId);

	/**
	 * 获取分页数据
	 * 
	 * @param <T>
	 * @param entityClass
	 *            实体类
	 * @param pagedQuery
	 *            分页实体及分页信息
	 */
	void getScrollData(Class<T> entityClass, AbstractPagedQuery<T> pagedQuery);
}
