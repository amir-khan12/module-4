package com.cg.dao;

import java.util.List;

import com.cg.bean.ShopBean;
import com.cg.exception.ShopException;




public interface IShopdao {
	
	public List<ShopBean> retrieveAllShop() throws ShopException;
	
	public ShopBean deleteShop(int productId) throws ShopException;

}
