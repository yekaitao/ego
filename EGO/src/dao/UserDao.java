package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import pojo.JaneAddress;

@Repository("userDao")
@Mapper
public interface UserDao {
	public List<JaneAddress> getAllAddress(int uid);
}
