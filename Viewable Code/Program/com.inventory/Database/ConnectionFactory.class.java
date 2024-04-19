package com.inventory.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//
// Public class "ConnectionFactory" that connects the database host name to the program
//
public class ConnectionFactory {
  static final String driver = "com.mysql.cj.jdbc.Driver";
  
  static final String url = "mysql://avnadmin:AVNS_-s1Ei3aVfoNwJv3zM0w@mysql-2274e2da-inventorym.a.aivencloud.com:24090/defaultdb?ssl-mode=REQUIRED";
  
  static String username;
  
  static String password;
  
  Properties prop;
  
  Connection conn = null;
  
  Statement statement = null;
  
  ResultSet resultSet = null;
  
  //
  // Retrieves username and password from document "DBCredentials.xml".
  //
  public ConnectionFactory() {
    try {
      this.prop = new Properties();
      this.prop.loadFromXML(new FileInputStream("lib/DBCredentials.xml"));
    } catch (IOException e) {
      e.printStackTrace();
    } 
    username = this.prop.getProperty("username");
    password = this.prop.getProperty("password");
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.conn = DriverManager.getConnection("mysql://avnadmin:AVNS_-s1Ei3aVfoNwJv3zM0w@mysql-2274e2da-inventorym.a.aivencloud.com:24090/defaultdb?ssl-mode=REQUIRED", username, password);
      this.statement = this.conn.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  //
  // Retrieves connection to driver of database "Connected successfully".
  //
  public Connection getConn() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.conn = DriverManager.getConnection("jdbc:mysql://mysql-2274e2da-inventorym.a.aivencloud.com:24090/inventory", username, password);
      System.out.println("Connected successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.conn;
  }
  
  //
  // Checks username and password login.
  //
  public boolean checkLogin(String username, String password, String userType) {
    String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "' AND usertype='" + userType + "' LIMIT 1";
    try {
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        return true; 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return false;
  }
}
