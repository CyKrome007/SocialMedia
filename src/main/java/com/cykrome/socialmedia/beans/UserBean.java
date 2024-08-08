package com.cykrome.socialmedia.beans;

public class UserBean {
    private String uname;
    private String passwd;
    private String email;
    private String phone;
    private java.sql.PreparedStatement preparedStatement;

    // Setters
    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPreparedStatement(java.sql.PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    // Getters
    public String getUname() {
        return uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public java.sql.PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
}
