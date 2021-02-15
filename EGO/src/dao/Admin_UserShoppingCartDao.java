package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.UserShoppingCart;;

@Repository("admin_UserShoppingCartDao")
@Mapper
public interface Admin_UserShoppingCartDao {

	public List<UserShoppingCart> getUserShoppingCart();

	public int updateUserShoppingCart(UserShoppingCart userShoppingCart);

	public int deleteUserShoppingCart(UserShoppingCart userShoppingCart);

}
