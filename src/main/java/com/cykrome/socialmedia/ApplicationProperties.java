package com.cykrome.socialmedia;

public class ApplicationProperties {
    private final String class_name = "com.mysql.cj.jdbc.Driver";
    private final String connection_url = "jdbc:mysql://localhost:3306/?user=SocialMedia";
    private final String user_name = "SocialMedia";
    private final String password = "Xud2UD+E%I";
    private final String database_name = "SOCIALMEDIA_DB";
    private final String accounts_table_name = "ACCOUNTS_T";

    public String getClass_name() {
        return class_name;
    }

    public String getConnection_url() {
        return connection_url;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase_name() {
        return database_name;
    }

    public String getAccounts_table_name() {
        return accounts_table_name;
    }
}
