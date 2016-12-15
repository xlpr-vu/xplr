package facebook4j.examples.signin;

import facebook4j.Facebook;
import facebook4j.FacebookException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlpr.dao.EventDao;

import java.io.IOException;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 6305643034487441839L;
    private EventDao dao;
    public CallbackServlet() {
        super();
        dao = new EventDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
//        try {
//        	request.getSession().setAttribute("event", dao.getAllEvents());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        
        response.sendRedirect(request.getContextPath() + "/events");
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/events.html");
//        dispatcher.forward(request, response);
    }
}
