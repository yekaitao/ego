package service;

import java.util.List;

import pojo.JaneAddress;

public interface UserService {
	public List<JaneAddress> getAllAddress(int uid);
}
