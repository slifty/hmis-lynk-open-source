package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.ServiceEntity;

public class ServiceDaoImpl extends QueryExecutorImpl implements
		ServiceDao {

	@SuppressWarnings("unchecked")
	public ServiceEntity findByExternalId(String externalId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceEntity.class);
		criteria.add(Restrictions.eq("externalId",externalId));
		
		List<ServiceEntity> services = (List<ServiceEntity>) findByCriteria(criteria);
		
		if(services.size()>0) return services.get(0);
		return new ServiceEntity();
	}

}
