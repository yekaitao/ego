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

import dao.UserDao;
import pojo.JaneAddress;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/address/all")
	@ResponseBody
	public Map<String,Object> list(@RequestBody JSONObject json) {
		
		int uid=Integer.parseInt(json.getString("uid"));
		List<JaneAddress> address = userDao.getAllAddress(uid);

		Map<String,Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("data", address);
		
		return map;
	}
}
