package com.inventory.UI;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
import com.inventory.DTO.UserDTO;
import com.inventory.Database.ConnectionFactory;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//
//Creates public class "LoginPage" from "JFrame": includes UserDTO, LocalDateTime
//
public class LoginPage extends JFrame {
  UserDTO userDTO;
  
  LocalDateTime inTime;
  
  String userType;
  
  private JButton clearButton;
  
  private JComboBox<String> jComboBox1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JButton loginButton;
  
  private JPasswordField passText;
  
  private JTextField userText;
  
  public LoginPage() {
    initComponents();
    this.userDTO = new UserDTO();
  }
  
  //
  //Creates the display screen for the login page: organization, password field, and buttons.
  //
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.userText = new JTextField();
    this.passText = new JPasswordField();
    this.jLabel3 = new JLabel();
    this.jComboBox1 = new JComboBox<>();
    this.loginButton = new JButton();
    this.clearButton = new JButton();
    setDefaultCloseOperation(2);
    setTitle("Login");
    setBackground(new Color(102, 102, 102));
    setBounds(new Rectangle(500, 100, 0, 0));
    setName("loginFrame");
    this.jLabel1.setFont(new Font("Segoe UI", 0, 14));
    this.jLabel1.setText("Username:");
    this.jLabel2.setFont(new Font("Segoe UI", 0, 14));
    this.jLabel2.setText("Password:");
    this.jLabel3.setFont(new Font("Poor Richard", 1, 24));
    this.jLabel3.setHorizontalAlignment(0);
    this.jLabel3.setText("STORE  INVENTORY");
    this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ADMINISTRATOR", "EMPLOYEE" }));
    this.loginButton.setText("LOGIN");
    this.loginButton.setCursor(new Cursor(12));
    this.loginButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            LoginPage.this.loginButtonActionPerformed(evt);
          }
        });
    this.clearButton.setText("CLEAR");
    this.clearButton.setCursor(new Cursor(12));
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            LoginPage.this.clearButtonActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(47, 47, 47)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addGroup(layout.createSequentialGroup()
              .addGap(42, 42, 42)
              .addComponent(this.loginButton, -2, 100, -2)
              .addGap(18, 18, 18)
              .addComponent(this.clearButton, -2, 100, -2))
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 74, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.userText))
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel2, -2, 74, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.passText))
            .addComponent(this.jComboBox1, 0, -1, 32767)
            .addComponent(this.jLabel3, -1, 284, 32767))
          .addContainerGap(52, 32767)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(44, 44, 44)
          .addComponent(this.jLabel3, -2, 44, -2)
          .addGap(57, 57, 57)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.userText, -1, 31, 32767)
            .addComponent(this.jLabel1, -1, -1, 32767))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(this.passText, -2, 32, -2)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel2, -2, 33, -2)
              .addGap(1, 1, 1)))
          .addGap(18, 18, 18)
          .addComponent(this.jComboBox1, -1, 28, 32767)
          .addGap(46, 46, 46)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.loginButton, -2, 37, -2)
            .addComponent(this.clearButton, -2, 37, -2))
          .addGap(80, 80, 80)));
    pack();
  }
  
  //
  // Encrypts the text by using a password.
  //
  private String encryptPass(String pass) {
    String encPass = null;
    if (pass == null)
      return null; 
    try {
      MessageDigest mDigest = MessageDigest.getInstance("MD5");
      mDigest.update(pass.getBytes(), 0, pass.length());
      encPass = (new BigInteger(1, mDigest.digest())).toString(16);
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return encPass;
  }
  
  private void loginButtonActionPerformed(ActionEvent evt) {
    String username = this.userText.getText();
    String password = this.passText.getText();
    this.userType = (String)this.jComboBox1.getSelectedItem();
    if ((new ConnectionFactory()).checkLogin(username, password, this.userType)) {
      this.inTime = LocalDateTime.now();
      this.userDTO.setInTime(String.valueOf(this.inTime));
      dispose();
      new Dashboard(username, this.userType, this.userDTO);
    } else {
      JOptionPane.showMessageDialog(null, "Invalid username or password.");
    } 
  }
  
  private void clearButtonActionPerformed(ActionEvent evt) {
    this.userText.setText("");
    this.passText.setText("");
  }
  
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel((LookAndFeel)new FlatMaterialDarkerIJTheme());
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new LoginPage()).setVisible(true);
          }
        });
  }
}
