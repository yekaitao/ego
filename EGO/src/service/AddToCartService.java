package service;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pojo.ProductCart;
import pojo.ProductTot;
public interface AddToCartService {
	public boolean addToCart(ProductCart productCart);
}




