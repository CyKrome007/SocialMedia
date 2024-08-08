package com.cykrome.socialmedia.pages;

import com.cykrome.socialmedia.ApplicationProperties;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register-user")
@MultipartConfig
public class RegisterUser extends HttpServlet {

    private boolean validateUsername(HttpServletRequest req, HttpServletResponse resp, String uname, Connection con) {
        try{
            PreparedStatement ps = con.prepareStatement("SELECT uname FROM SOCIALMEDIA_DB.ACCOUNTS_T WHERE uname = ?;");
            ps.setString(1, uname);

            PrintWriter out = resp.getWriter();

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                if(rs.getString("uname").equals(uname)){
                    req.getRequestDispatcher("/register").include(req, resp);
                    out.println("<p style = 'color: red'>Username Already Exists</p>");
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } catch (SQLException | ServletException | IOException e) {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        ApplicationProperties applicationProperties = new ApplicationProperties();
        Connection con;
        try {
            Class.forName(applicationProperties.getClass_name());
            con = DriverManager.getConnection(
                    applicationProperties.getConnection_url(),
                    applicationProperties.getUser_name(),
                    applicationProperties.getPassword()
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher rd;
        PrintWriter out = resp.getWriter();

        String uname = req.getParameter("uname");

        if (!validateUsername(req, resp, uname, con)) {
            return;
        }

        String pass = req.getParameter("password");
        String mail = req.getParameter("mail");
        String repass = req.getParameter("re-password");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        Part profile_photo = req.getPart("profile_photo");

        out.println(profile_photo.getSubmittedFileName());
    }
}
