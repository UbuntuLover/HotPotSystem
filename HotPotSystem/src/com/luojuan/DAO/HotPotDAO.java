package com.luojuan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




import com.luojuan.bean.Hotpot;
import com.luojuan.common.ConnectionFactory;

public class HotPotDAO {
	/**
	 * 执行插入火锅。
	 * */
	public void addHotpot(Hotpot hotpot) throws Exception {
		Connection connection = ConnectionFactory.getConn();
		String sql = "insert into hotpot values(?,?,?)" ;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, hotpot.getFlavour());
		preparedStatement.setString(2, hotpot.getPrice());
		preparedStatement.setString(3, hotpot.getId());
		preparedStatement.executeUpdate();
	}
	/**
	 * 查询所有火锅。
	 * */
	public List<Hotpot> findAll() throws Exception {
		List<Hotpot> list = new ArrayList<Hotpot>();
		Connection connection = ConnectionFactory.getConn();
		String sql = "select * from hotpot";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			String flavour = resultSet.getString("flavour");
			String price = resultSet.getString("price");
			String id = resultSet.getString("id");
			Hotpot hotpot = new Hotpot(flavour, price, id);
			list.add(hotpot);
		}
		
		return list;
		
	}
	/**
	 * 按照id查询火锅。
	 * */
	public List<Hotpot> findById(String id) throws Exception {
		List<Hotpot> list = new ArrayList<Hotpot>();
		Hotpot hotpot = null;
		Connection connection = ConnectionFactory.getConn();
		String sql = "select * from hotpot where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			String flavour = resultSet.getString("flavour");
			String price = resultSet.getString("price");
			hotpot = new Hotpot(flavour, price, id);
			list.add(hotpot);
		}
		
		
		return list;
	}
	/**
	 * 根据ID删除火锅。
	 * */
	public void deleteById(String id) throws Exception {
		Connection connection = ConnectionFactory.getConn();
		String sql = "DELETE FROM hotpot WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.executeUpdate();
	}
	
	
	
}
