package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.bean.ShopBean;
import com.cg.exception.ShopException;

@Repository
@Transactional
public class ShopDaoImpl implements IShopdao {

	ShopBean bean = new ShopBean();
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<ShopBean> retrieveAllShop() throws ShopException {
		List<ShopBean> list = null;
		System.out.println("in dao" + bean.getProductId());
		try {
			TypedQuery<ShopBean> query = entityManager.createQuery("from ShopBean",ShopBean.class);
			list= query.getResultList();
		} catch (Exception e) {
			throw new ShopException("Unable to retrieve all records in dao layer"+e.getMessage());
			
		}
		return list;
	}
	


	@Override
	public ShopBean deleteShop(int productId) throws ShopException {
		System.out.println("productId: " + productId);
		ShopBean bean = entityManager.find(ShopBean.class, productId);

		if (bean == null) {
			System.out.println("  delete fail ");
			throw new ShopException(" product not found ");
		} else {
			System.out.println(" delete success ");
			entityManager.remove(bean);
		}

		return bean;
	}

}
