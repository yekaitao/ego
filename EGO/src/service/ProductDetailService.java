package service;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pojo.ProductTot;
public interface ProductDetailService {
	public ProductTot productTot(Model model,HttpServletRequest request);
}
