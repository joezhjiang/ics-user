package org.ics.user.basic;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author: joe
 * @createtime: 2011-6-10 下午12:58:38
 * @version: 1.0
 * @param <T>
 * @filename: AbstractPagedQuery.java
 * @description:
 */
public abstract class AbstractPagedQuery<T> {
	/**
	 * 默认值
	 */
	private final Integer DEFAULT_CURR_PAGE = 1;
	private final Integer DEFAULT_PAGE_SIZE = 15;
	private final Integer DEFAULT_TOTAL_RECORD = -1;

	/**
	 * 一页显示的记录数
	 */
	private Integer pageSize = DEFAULT_PAGE_SIZE;
	/**
	 * 当前页码,第几页
	 */
	private Integer currPage = DEFAULT_CURR_PAGE;
	/**
	 * 共页数
	 */
	private Integer totalPage;
	/**
	 * 起始记录
	 */
	private Integer startRecord;
	/**
	 * 结束记录
	 */
	private Integer endRecord;
	/**
	 * 总记录数
	 */
	private Integer totalRecord = DEFAULT_TOTAL_RECORD;
	/**
	 * 返回的结果集
	 */
	private List<T> queryResults;

	/**
	 * @return the queryResults
	 */
	public List<T> getQueryResults() {
		return queryResults;
	}

	/**
	 * @param queryResults
	 *            the queryResults to set
	 */
	public void setQueryResults(List<T> queryResults) {
		this.queryResults = queryResults;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the currPage
	 */
	public Integer getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage
	 *            the currPage to set
	 */
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * @return the totalRecord
	 */
	public Integer getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord
	 *            the totalRecord to set
	 */
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the startRecord
	 */
	public Integer getStartRecord() {
		return startRecord;
	}

	/**
	 * @param startRecord
	 *            the startRecord to set
	 */
	public void setStartRecord(Integer startRecord) {
		this.startRecord = startRecord;
	}

	/**
	 * 设置起始记录不用自己计算
	 */
	public void setStartRecord() {
		this.startRecord = (currPage - 1) * pageSize;
	}

	/**
	 * @return the endRecord
	 */
	public Integer getEndRecord() {
		return endRecord;
	}

	/**
	 * @param endRecord
	 *            the endRecord to set
	 */
	public void setEndRecord(Integer endRecord) {
		this.endRecord = endRecord;
	}

	/**
	 * 设置结束记录不用自己计算
	 */
	public void setEndRecord() {
		if (totalPage.equals(currPage)) {// 最后一页
			this.endRecord = totalRecord;
		} else {
			this.endRecord = currPage * pageSize;
		}
	}

	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 设置总页数不用自己计算
	 */
	public void setTotalPage() {
		this.totalPage = (int) Math.ceil(totalRecord.doubleValue()
				/ pageSize.doubleValue());
	}

	/**
	 * 构造Hibernate Query 对象. 如果isQueryTotalCount=true则构造查询总数的(sql)
	 * Query,否则,构造查询指定范围纪录的(sql) Query
	 * 
	 * @param session
	 *            Hibernate Session
	 * @param isQueryTotalCount
	 *            是否构造查询总数的(sql) Query
	 * @return Query
	 */
	public abstract Query buildQuery(Session session, boolean isQueryTotalCount);

	/**
	 * 获取分页参数
	 * 
	 * @return Map<String, Object>
	 */
	public abstract void getQueryParams(Map<String, Object> queryParams);
}
