package com.xlpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xlpr.model.Event;
import com.xlpr.util.DbUtil;

public class EventDao {

	private Connection connection;

	public EventDao() {
		connection = DbUtil.getConnection();
	}

	public void addEvent(Event event) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into event(title,img,short_description,long_description,longitude,latitude,begin_date,end_date,contact_email,address,ps1,val1,ps2,val2,ps3,val3,ps4,val4,ps5,val5) values (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, event.getTitle());
			preparedStatement.setString(2, event.getImg());
			preparedStatement.setString(3, event.getShort_description());
			preparedStatement.setString(4, event.getLong_description());
			preparedStatement.setFloat(5, event.getLongitude());
			preparedStatement.setFloat(6, event.getLatitude());
			preparedStatement.setDate(7, new java.sql.Date(event.getBegin_date().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(event.getEnd_date().getTime()));
			preparedStatement.setString(9, event.getContact_email());
			preparedStatement.setString(10, event.getAddress());
			preparedStatement.setString(11, event.getPs1());
			preparedStatement.setString(12, event.getVal1());
			preparedStatement.setString(13, event.getPs2());
			preparedStatement.setString(14, event.getVal2());
			preparedStatement.setString(15, event.getPs3());
			preparedStatement.setString(16, event.getVal3());
			preparedStatement.setString(17, event.getPs4());
			preparedStatement.setString(18, event.getVal4());
			preparedStatement.setString(19, event.getPs5());
			preparedStatement.setString(20, event.getVal5());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEvent(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from event where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from event");
			while (rs.next()) {
				Event event = new Event();
				event.setId(rs.getInt("id"));
				event.setTitle(rs.getString("title"));
				event.setImg(rs.getString("img"));
				event.setShort_description(rs.getString("short_description"));
				event.setLong_description(rs.getString("long_description"));
				event.setLongitude(rs.getFloat("longitude"));
				event.setLatitude(rs.getFloat("latitude"));
				event.setBegin_date(rs.getDate("begin_date"));
				event.setEnd_date(rs.getDate("end_date"));
				event.setContact_email(rs.getString("contact_email"));
				event.setAddress(rs.getString("address"));
				event.setPs1(rs.getString("ps1"));
				event.setPs2(rs.getString("ps2"));
				event.setPs3(rs.getString("ps3"));
				event.setPs4(rs.getString("ps4"));
				event.setPs5(rs.getString("ps5"));
				event.setVal1(rs.getString("val1"));
				event.setVal2(rs.getString("val2"));
				event.setVal3(rs.getString("val3"));
				event.setVal4(rs.getString("val4"));
				event.setVal5(rs.getString("val5"));
				events.add(event);
//				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return events;
	}

	public Event getEventById(int eventId) {
		Event event = new Event();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from event where id=?");
			preparedStatement.setInt(1, eventId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				event.setId(rs.getInt("id"));
				event.setTitle(rs.getString("title"));
				event.setImg(rs.getString("img"));
				event.setShort_description(rs.getString("short_description"));
				event.setLong_description(rs.getString("long_description"));
				event.setLongitude(rs.getFloat("longitude"));
				event.setLatitude(rs.getFloat("latitude"));
				event.setBegin_date(rs.getDate("begin_date"));
				event.setEnd_date(rs.getDate("end_date"));
				event.setContact_email(rs.getString("contact_email"));
				event.setAddress(rs.getString("address"));
				event.setPs1(rs.getString("ps1"));
				event.setPs2(rs.getString("ps2"));
				event.setPs3(rs.getString("ps3"));
				event.setPs4(rs.getString("ps4"));
				event.setPs5(rs.getString("ps5"));
				event.setVal1(rs.getString("val1"));
				event.setVal2(rs.getString("val2"));
				event.setVal3(rs.getString("val3"));
				event.setVal4(rs.getString("val4"));
				event.setVal5(rs.getString("val5"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return event;
	}
}
