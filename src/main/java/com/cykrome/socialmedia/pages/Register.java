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

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/register")
@MultipartConfig
public class Register extends HttpServlet {

    private boolean credentialValidation(Connection con, String column, String credential) {
        // Username Validation
        try {
            PreparedStatement test = con.prepareStatement("SELECT " + column + " FROM SOCIALMEDIA_DB.ACCOUNTS_T WHERE " + column + " = ?;");
            test.setString(1, credential);
            ResultSet rs = test.executeQuery();
            if (rs.next()) {
                if(column.equals("uname")){
                    return !credential.equals(rs.getString("uname"));
                }
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String uname  = req.getParameter("uname");
        String mail = req.getParameter("mail");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String re_password = req.getParameter("re-password");
        Part profile_photo  = req.getPart("profile_photo");
        InputStream profile_photo_is = profile_photo.getInputStream();

        ApplicationProperties ap = new ApplicationProperties();
        try {
            Class.forName(ap.getClass_name());
            Connection con = DriverManager.getConnection(
                    ap.getConnection_url(),
                    ap.getUser_name(),
                    ap.getPassword()
            );

            // Username Validation
            if (!credentialValidation(con, "uname", uname)) {
                throw new Exception("Username Already exists.<br>Username Must Be Unique");
            }

            // Mail Validation
            if (!credentialValidation(con, "mail", mail)) {
                throw new Exception("An Account with this Email Already exists.<br>Try Logging in.");
            }

            // Phone Validation
            if(phone != null && !phone.isEmpty()){
                if (!credentialValidation(con, "phone", phone)) {
                    throw new Exception("An Account with this Phone Number Already exists.<br>Try Logging in.");
                }
            } else if(phone.isEmpty()){
                phone = null;
            }

            for(int i = 0; i < password.length(); i++){
                if(password.charAt(i) == ' '){
                    throw new Exception("Password Cannot Contain Space");
                }
            }

            if(!password.equals(re_password)){
                throw new Exception("Password Do not Match");
            }

            // Change fname and lname to Title Case
            if(Character.isLowerCase(fname.charAt(0))){
                fname = fname.substring(0, 1).toUpperCase() + fname.substring(1).toLowerCase();
            }

            if(Character.isLowerCase(lname.charAt(0))){
                lname = lname.substring(0, 1).toUpperCase() + lname.substring(1).toLowerCase();
            }

            //String
            PreparedStatement ps = con.prepareStatement("INSERT INTO SOCIALMEDIA_DB.ACCOUNTS_T values(?,?,?,?,?,?,NULL,CURDATE(),?);");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, uname);
            ps.setString(4, mail);
            ps.setString(5, phone);
            ps.setBlob(6, profile_photo_is);
            ps.setString(7, password);

            int count = ps.executeUpdate();
            if(count > 0) {
                RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
                rd.forward(req, resp);
                System.out.println("Registered Successfully");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
                rd.include(req, resp);
                PrintWriter out = resp.getWriter();
                out.println("<h5 style='color:red'>Registration Failed Try Again</h5>'");
            }

        } catch (Exception e){

            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
            PrintWriter out = resp.getWriter();
            out.println(e.getMessage());

//            out.println(
//                    "<br><br>fname: " + fname +
//                            "<br><br>lname: " + lname +
//                            "<br><br>mail: " + mail +
//                            "<br><br>uname: " + uname +
//                            "<br><br>Phone: " + phone +
//                            "<br><br>password: " + password
//            );

            out.println("<h5 style='color:red'>Registration Failed Try Again</h5>'");
        }

    }
}
