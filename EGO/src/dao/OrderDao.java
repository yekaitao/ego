package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.JaneOrder;
import pojo.JaneOrder2;
import pojo.JaneOrder3;
import pojo.JaneProduct;

@Repository("orderDao")
@Mapper
public interface OrderDao {
	public List<JaneProduct> getPreOrder(String[] pids);
	public int addOrder(JaneOrder janeOrder);
	public int addOrderDetail(JaneOrder janeOrder);
	public List<JaneOrder2> getOrders(JaneOrder janeOrder);
	public List<JaneOrder3> getOrderDetail(int oid);
	public int updateOrder(int oid);
	public int deleteOrder(int oid);
	public int deleteOrderDetail(int oid);
}
