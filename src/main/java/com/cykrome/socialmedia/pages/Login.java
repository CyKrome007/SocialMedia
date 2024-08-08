package com.cykrome.socialmedia.pages;

import com.cykrome.socialmedia.ApplicationProperties;
import com.cykrome.socialmedia.beans.UserBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    private void setSessionData(ResultSet rs, HttpSession session) throws SQLException{
        try {
            String x = rs.getString("fname");
            if (x != null) {
                session.setAttribute("fname", x);
            }
            x = rs.getString("lname");
            if (x != null) {
                session.setAttribute("lname", x);
            }
            x = rs.getString("mail");
            if (x != null) {
                session.setAttribute("mail", x);
            }
            x = rs.getString("passwd");
            if (x != null) {
                session.setAttribute("passwd", x);
            }
            x = rs.getString("uname");
            if (x != null) {
                session.setAttribute("uname", x);
            }
            x = rs.getString("bio");
            if (x != null) {
                session.setAttribute("bio", x);
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    private boolean execQueryAndForward(HttpServletRequest req, HttpServletResponse resp, PreparedStatement ps) throws SQLException, IOException, ServletException {
        ResultSet rs = ps.executeQuery();
        PrintWriter out = resp.getWriter();
        if (rs.next()) {
            try {

                req.getRequestDispatcher("/home.jsp").include(req, resp);
                HttpSession session = req.getSession();

                setSessionData(rs, session);

                return true;
            } catch (Exception e) {
                throw e;
            }
        } else {
            return false;
        }
    }

    private boolean tryLogin(HttpServletRequest req, HttpServletResponse resp, UserBean user) throws ServletException, IOException, SQLException {
        PreparedStatement ps = user.getPreparedStatement();
        ResultSet rs = ps.executeQuery();
        PrintWriter out = resp.getWriter();
        if (rs.next()) {
            try {

                req.getRequestDispatcher("/home.jsp").include(req, resp);
                HttpSession session = req.getSession();

                setSessionData(rs, session);

                return true;
            } catch (Exception e) {
                throw e;
            }
        } else {
            return false;
        }
    }

    private static UserBean setupUserBean(Connection con, String column, String credential1, String password) throws SQLException {
        UserBean user;
        PreparedStatement ps;
        ps = con.prepareStatement("SELECT * FROM SOCIALMEDIA_DB.ACCOUNTS_T WHERE " + column + " = ? and passwd = ?;");
        ps.setString(1, credential1);
        ps.setString(2, password);
        user = new UserBean();
        if(column.equalsIgnoreCase("mail")) {
            user.setEmail(credential1);
        } else if(column.equalsIgnoreCase("uname")) {
            user.setUname(credential1);
        } else if(column.equalsIgnoreCase("phone")) {
            user.setPhone(credential1);
        }
        user.setPasswd(password);
        user.setPreparedStatement(ps);
        return user;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String credential1 = req.getParameter("credential1");
        String password = req.getParameter("password");
        RequestDispatcher rd;
        HttpSession session;
        ResultSet rs;
        try {
            ApplicationProperties applicationProperties = new ApplicationProperties();
            Class.forName(applicationProperties.getClass_name());
            Connection con = DriverManager.getConnection(
                    applicationProperties.getConnection_url(),
                    applicationProperties.getUser_name(),
                    applicationProperties.getPassword()
            );

            req.getSession().setAttribute("connection", con);

            UserBean user = setupUserBean(con, "mail", credential1, password);
            if(tryLogin(req, resp, user)) {
                out.println("Logged in Using Email");
            } else {
                user = setupUserBean(con, "uname", credential1, password);
                if(tryLogin(req, resp, user)) {
                    out.println("logged in Using Username");
                } else {
                    user = setupUserBean(con, "phone", credential1, password);
                    if(tryLogin(req, resp, user)) {
                        out.println("logged in Using Phone");
                    }
                    else {
                        req.getRequestDispatcher("/login.jsp").include(req, resp);
                        out.println("<h4 style='color:red'>unauthorized</h4>");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
