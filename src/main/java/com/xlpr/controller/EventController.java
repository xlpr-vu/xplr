package com.xlpr.controller;

import java.awt.List;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.opensymphony.xwork2.ActionContext;
import com.xlpr.dao.EventDao;
import com.xlpr.model.Event;

public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/events.jsp";
	private EventDao dao;
	private Event eventList;
	public Event getEventList() {
		return eventList;
	}

	public void setEventList(Event eventList) {
		this.eventList = eventList;
	}

	PersonalityInsights service = new PersonalityInsights("2016-10-19");

	public EventController() {
		super();
		dao = new EventDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("events", dao.getAllEvents());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/png");
		Event event = new Event();
		String DescriptionLong = request.getParameter("long_description");
		System.out.println(DescriptionLong);
		service.setUsernameAndPassword("910c7643-c1cf-4257-8f0f-dd09d1d8dbda", "Edqkxs1UZyuI");
		Profile profile = service.getProfile(DescriptionLong).execute();
		JSONObject json = new JSONObject(profile);
		try {
			System.out.println(json.get("personality"));
			JSONArray array = (JSONArray) json.get("personality");
			System.out.println(array);
//			ServletOutputStream out = response.getOutputStream();
			for (int n = 0; n < array.length(); n++) {
				JSONObject big5 = array.getJSONObject(n);
				big5.remove("children");
				if (n == 1) {
					event.setPs1(big5.get("name").toString());
					event.setVal1(big5.get("percentile").toString());
				} else if (n == 2) {
					event.setPs2(big5.get("name").toString());
					event.setVal2(big5.get("percentile").toString());
				} else if (n == 3) {
					event.setPs3(big5.get("name").toString());
					event.setVal3(big5.get("percentile").toString());
				} else if (n == 4) {
					event.setPs4(big5.get("name").toString());
					event.setVal4(big5.get("percentile").toString());
				} else {
					event.setPs5(big5.get("name").toString());
					event.setVal5(big5.get("percentile").toString());
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		event.setTitle(request.getParameter("title"));
		event.setImg(request.getParameter("img"));
		event.setShort_description(request.getParameter("short_description"));
		event.setLong_description(DescriptionLong);
		event.setContact_email(request.getParameter("contact_email"));
		event.setAddress(request.getParameter("address"));
		Float longFloat = new Float(request.getParameter("longitude"));
		Float latFloat = new Float(request.getParameter("latitude"));
		event.setLongitude(longFloat);
		event.setLatitude(latFloat);
		try {
			Date bDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("begin_date"));
			Date eDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("end_date"));
			event.setBegin_date(bDate);
			event.setEnd_date(eDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()) {
			dao.addEvent(event);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.getSession().setAttribute("event", dao.getAllEvents());
//		request.getSession().setAttribute("event", dao.getAllEvents());
		eventList=(Event) dao.getAllEvents();
		System.out.println(dao.getAllEvents());
		view.forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/events.jsp");
	}
}