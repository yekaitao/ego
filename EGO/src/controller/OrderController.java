package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import dao.OrderDao;
import pojo.JaneOrder;
import pojo.JaneOrder2;
import pojo.JaneOrder3;
import pojo.JaneProduct;

@Controller
@RequestMapping("/order/item")
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping("/prepare")
	@ResponseBody
	public Map<String,Object> prepare(@RequestBody JSONObject json) {
		
		String[] pids = json.getString("pids").split(",");
		List<JaneProduct> products = orderDao.getPreOrder(pids);

		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("data", products);
		
		return map;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Map<String,Object> create(@RequestBody JSONObject json) {
		int uid = Integer.parseInt(json.getString("uid"));
		int aid = Integer.parseInt(json.getString("aid")); 
		String[] pids = json.getString("pids").split(",");
		String[] counts = json.getString("counts").split(",");
		//List<JaneProduct> products = orderDao.getPreOrder(pids);
		JaneOrder janeOrder = new JaneOrder();
		janeOrder.setOrder_time(new Date().getTime());
		janeOrder.setUid(uid);
		janeOrder.setAid(aid);
		orderDao.addOrder(janeOrder);
		for(int i=0;i<pids.length;i++) {
			janeOrder.setCount(Integer.parseInt(counts[i]));
			janeOrder.setPid(Integer.parseInt(pids[i]));
			orderDao.addOrderDetail(janeOrder);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "success");
		
		return map;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> list(@RequestBody JSONObject json) {
		
		int uid = Integer.parseInt(json.getString("uid"));
		int status = Integer.parseInt(json.getString("status"));
		JaneOrder janeOrder = new JaneOrder();
		janeOrder.setUid(uid);
		janeOrder.setStatus(status);
		
		List<JaneOrder2> orders = orderDao.getOrders(janeOrder);

		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("data", orders);
		
		return map;
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public Map<String,Object> detail(@RequestBody JSONObject json) {
		
		int oid = Integer.parseInt(json.getString("oid"));
		
		List<JaneOrder3> orders = orderDao.getOrderDetail(oid);

		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("data", orders);
		
		return map;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> update(@RequestBody JSONObject json) {
		
		int oid=Integer.parseInt(json.getString("oid"));
		orderDao.updateOrder(oid);

		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "delete succ");
		
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(@RequestBody JSONObject json) {
		
		int oid=Integer.parseInt(json.getString("oid"));
		orderDao.deleteOrderDetail(oid);
		orderDao.deleteOrder(oid);

		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "delete succ");
		
		return map;
	}
}
