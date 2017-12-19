package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.ShopBean;
import com.cg.dao.IShopdao;
import com.cg.exception.ShopException;


@Service
public class ServiceShopImpl implements IServiceShop {
ShopBean bean = new ShopBean();
	
	@Autowired
	private IShopdao ShopDao;




@Override
public List<ShopBean> retrieveAllShop() throws ShopException {
	
	System.out.println("in service" + bean.getProductId());
	
	return ShopDao.retrieveAllShop();
}




@Override
public ShopBean deleteShop(int productId) throws ShopException {
	
	return ShopDao.deleteShop(productId);
}

}
