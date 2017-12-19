package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bean.ShopBean;
import com.cg.exception.ShopException;
import com.cg.service.IServiceShop;








@Controller
public class ShopController {

	@Autowired
	private IServiceShop ServiceShop;
	
	/*@RequestMapping("/showHomedw")
	public String showHomePage() {
		return ("index");
	}
*/ 
	@RequestMapping(value="/showHome")
	public ModelAndView retrieveAllShop(@ModelAttribute("shop") ShopBean bean,BindingResult result)
	{
		System.out.println("in controller"+bean.getProductId());
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("index");
			mv.addObject("message", "Binding Failed");
		} else {
		try {
			List<ShopBean> list= ServiceShop.retrieveAllShop();
			mv.setViewName("index");
			mv.addObject("list", list);
		} catch (ShopException e) {
			mv.setViewName("error");
			mv.addObject("message", e.getMessage());
		}
		
		}
		return (mv);
	}
	@RequestMapping(value = "/delete")
	public ModelAndView deleteShop(
			@ModelAttribute("shop") ShopBean bean, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		System.out.println(" in controller " + bean.getProductId());
		if (result.hasErrors()) {
			mv.setViewName("error");
			mv.addObject("message", "Binding Failed");
		} else {
			try {
				ShopBean tbean = ServiceShop.deleteShop(bean
						.getProductId());
				mv.addObject("tbean", tbean);
				List<ShopBean> list= ServiceShop.retrieveAllShop();
				mv.setViewName("index");
				mv.addObject("list", list);
				

			} catch (ShopException e) {
				mv.setViewName("error");
				mv.addObject("message", e.getMessage());
			}
		}
		return (mv);
	}
}

