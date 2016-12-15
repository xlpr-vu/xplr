package com.xlpr.event;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.xlpr.dao.EventDao;

public class CreatEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventDao dao;
	public CreatEventServlet() {
        super();
        dao = new EventDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			request.getSession().setAttribute("event", dao.getAllEvents());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(dao.getAllEvents());
		response.sendRedirect(request.getContextPath() + "/events.jsp");
	}


}
