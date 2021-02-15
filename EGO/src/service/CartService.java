package service;

import java.util.List;

import pojo.JaneCart;

public interface CartService {
	public List<JaneCart> selectCarts(int uid);
	public int deleteCart(JaneCart janeCart);
}
