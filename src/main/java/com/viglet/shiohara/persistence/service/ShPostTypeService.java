package com.viglet.shiohara.persistence.service;

import java.util.List;

import javax.persistence.TypedQuery;

import com.viglet.shiohara.persistence.model.ShPostType;

public class ShPostTypeService extends ShBaseService {
	public void save(ShPostType shPostType) {
		em.getTransaction().begin();
		em.persist(shPostType);
		em.getTransaction().commit();
	}

	public List<ShPostType> listAll() {
		TypedQuery<ShPostType> q = em.createNamedQuery("ShPostType.findAll", ShPostType.class);
		return q.getResultList();
	}

	public ShPostType getUser(int userId) {
		return em.find(ShPostType.class, userId);
	}

	public boolean delete(int postTypeId) {
		ShPostType shPostType = em.find(ShPostType.class, postTypeId);
		em.getTransaction().begin();
		em.remove(shPostType);
		em.getTransaction().commit();
		return true;
	}
}
