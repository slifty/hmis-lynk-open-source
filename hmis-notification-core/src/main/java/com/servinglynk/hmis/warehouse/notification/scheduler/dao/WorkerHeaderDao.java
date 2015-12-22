package com.servinglynk.hmis.warehouse.notification.scheduler.dao;import java.util.List;import javax.transaction.Transactional;import org.hibernate.criterion.DetachedCriteria;import org.hibernate.criterion.Restrictions;import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.QueryExecutor;import com.servinglynk.hmis.warehouse.notification.persistence.entity.WorkerHeaderEntity;@Transactionalpublic class WorkerHeaderDao extends QueryExecutor implements IWorkerHeaderDao{		@SuppressWarnings("unchecked")	public List<WorkerHeaderEntity> findByExternalId(String externalId) {		DetachedCriteria query = DetachedCriteria.forClass(WorkerHeaderEntity.class);		query.add(Restrictions.eq("externalId",externalId));		query.add(Restrictions.eq("status","ACTIVE"));		return (List<WorkerHeaderEntity>) findByCriteria(query);	}}