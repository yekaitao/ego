package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import dao.CartDao;
import pojo.JaneCart;

@Controller
@RequestMapping("/cart/item")
public class CartController {
	@Autowired
	private CartDao cartDao;
	
	@RequestMapping("/add")
	public String add() {
		return "login";//跳转到“/WEB-INF/jsp/login.jsp”
	}
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> list(@RequestBody JSONObject json) {
		
		int uid=Integer.parseInt(json.getString("uid"));
		List<JaneCart> carts = cartDao.selectCarts(uid);
//		for(MyCart cart:carts) {
//			System.out.println(cart.toString());
//		}
		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("data", carts);
		
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(@RequestBody JSONObject json) {
		int uid=Integer.parseInt(json.getString("uid"));
		int pid=Integer.parseInt(json.getString("pid"));
		JaneCart janeCart = new JaneCart();
		janeCart.setUid(uid);
		janeCart.setPid(pid);
		
		
		cartDao.deleteCart(janeCart);
//		for(MyCart cart:carts) {
//			System.out.println(cart.toString());
//		}
		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "delete succ");
		
		return map;
	}
	@RequestMapping("/updatecount")
	public String updatecount() {
		return "regist";
	}
}
