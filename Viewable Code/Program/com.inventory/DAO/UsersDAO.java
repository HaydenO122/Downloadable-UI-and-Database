package com.inventory.DAO;

import com.inventory.DTO.UserDTO;
import com.inventory.Database.ConnectionFactory;
import com.inventory.UI.UsersPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserDAO {
  Connection conn = null;
  
  PreparedStatement prepStatement = null;
  
  Statement statement = null;
  
  ResultSet resultSet = null;
  
  public UserDAO() {
    try {
      this.conn = (new ConnectionFactory()).getConn();
      this.statement = this.conn.createStatement();
    } catch (SQLException ex) {
      ex.printStackTrace();
    } 
  }
  
  public void addUserDAO(UserDTO userDTO, String userType) {
    try {
      String query = "SELECT * FROM users WHERE name='" + userDTO.getFullName() + "' AND location='" + userDTO.getLocation() + "' AND phone='" + userDTO.getPhone() + "' AND usertype='" + userDTO.getUserType() + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next()) {
        JOptionPane.showMessageDialog(null, "User already exists");
      } else {
        addFunction(userDTO, userType);
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  public void addFunction(UserDTO userDTO, String userType) {
    try {
      String username = null;
      String password = null;
      String oldUsername = null;
      String resQuery = "SELECT * FROM users";
      this.resultSet = this.statement.executeQuery(resQuery);
      if (!this.resultSet.next()) {
        username = "root";
        password = "root";
      } 
      String query = "INSERT INTO users (name,location,phone,username,password,usertype) VALUES(?,?,?,?,?,?)";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, userDTO.getFullName());
      this.prepStatement.setString(2, userDTO.getLocation());
      this.prepStatement.setString(3, userDTO.getPhone());
      this.prepStatement.setString(4, userDTO.getUsername());
      this.prepStatement.setString(5, userDTO.getPassword());
      this.prepStatement.setString(6, userDTO.getUserType());
      this.prepStatement.executeUpdate();
      if ("ADMINISTRATOR".equals(userType)) {
        JOptionPane.showMessageDialog(null, "New administrator added.");
      } else {
        JOptionPane.showMessageDialog(null, "New employee added.");
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  public void editUserDAO(UserDTO userDTO) {
    try {
      String query = "UPDATE users SET name=?,location=?,phone=?,usertype=? WHERE username=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, userDTO.getFullName());
      this.prepStatement.setString(2, userDTO.getLocation());
      this.prepStatement.setString(3, userDTO.getPhone());
      this.prepStatement.setString(4, userDTO.getUserType());
      this.prepStatement.setString(5, userDTO.getUsername());
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "Updated Successfully.");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }
  
  public void deleteUserDAO(String username) {
    try {
      String query = "DELETE FROM users WHERE username=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, username);
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "User Deleted.");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    (new UsersPage()).loadDataSet();
  }
  
  public ResultSet getQueryResult() {
    try {
      String query = "SELECT * FROM users";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public ResultSet getUserDAO(String username) {
    try {
      String query = "SELECT * FROM users WHERE username='" + username + "'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException ex) {
      ex.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public void getFullName(UserDTO userDTO, String username) {
    try {
      String query = "SELECT * FROM users WHERE username='" + username + "' LIMIT 1";
      this.resultSet = this.statement.executeQuery(query);
      String fullName = null;
      if (this.resultSet.next())
        fullName = this.resultSet.getString(2); 
      userDTO.setFullName(fullName);
    } catch (SQLException ex) {
      ex.printStackTrace();
    } 
  }
  
  public ResultSet getUserLogsDAO() {
    try {
      String query = "SELECT users.name,userlogs.username,in_time,out_time,location FROM userlogs INNER JOIN users on userlogs.username=users.username";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public void addUserLogin(UserDTO userDTO) {
    try {
      String query = "INSERT INTO userlogs (username, in_time, out_time) values(?,?,?)";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, userDTO.getUsername());
      this.prepStatement.setString(2, userDTO.getInTime());
      this.prepStatement.setString(3, userDTO.getOutTime());
      this.prepStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public ResultSet getPassDAO(String username, String password) {
    try {
      String query = "SELECT password FROM users WHERE username='" + username + "' AND password='" + password + "'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException ex) {
      ex.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public void changePass(String username, String password) {
    try {
      String query = "UPDATE users SET password=? WHERE username='" + username + "'";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, password);
      this.prepStatement.setString(2, username);
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "Password has been changed.");
    } catch (SQLException ex) {
      ex.printStackTrace();
    } 
  }
  
  public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
    ResultSetMetaData metaData = resultSet.getMetaData();
    Vector<String> columnNames = new Vector<>();
    int colCount = metaData.getColumnCount();
    for (int col = 1; col <= colCount; col++)
      columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT)); 
    Vector<Vector<Object>> data = new Vector<>();
    while (resultSet.next()) {
      Vector<Object> vector = new Vector();
      for (int i = 1; i <= colCount; i++)
        vector.add(resultSet.getObject(i)); 
      data.add(vector);
    } 
    return new DefaultTableModel((Vector)data, columnNames);
  }
}
