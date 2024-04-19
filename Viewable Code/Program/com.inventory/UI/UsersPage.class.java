package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class UsersPage extends JPanel {
  String userType;
  
  String username;
  
  private JButton addButton;
  
  private JButton clearButton;
  
  private JButton deleteButton;
  
  private JPanel entryPanel;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTextField locationText;
  
  private JTextField nameText;
  
  private JPasswordField passText;
  
  private JTextField phoneText;
  
  private JTable userTable;
  
  private JComboBox<String> userTypeCombo;
  
  private JTextField usernameText;
  
  public UsersPage() {
    initComponents();
    loadDataSet();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.entryPanel = new JPanel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.nameText = new JTextField();
    this.locationText = new JTextField();
    this.phoneText = new JTextField();
    this.usernameText = new JTextField();
    this.passText = new JPasswordField();
    this.userTypeCombo = new JComboBox<>();
    this.addButton = new JButton();
    this.deleteButton = new JButton();
    this.clearButton = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.userTable = new JTable();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("USERS");
    this.entryPanel.setBorder(BorderFactory.createTitledBorder("Enter User Details"));
    this.jLabel2.setText("Full Name:");
    this.jLabel3.setText("Location:");
    this.jLabel4.setText("Contact:");
    this.jLabel5.setText("Username:");
    this.jLabel6.setText("Password:");
    this.userTypeCombo.setModel(new DefaultComboBoxModel<>(new String[] { "ADMINISTRATOR", "EMPLOYEE" }));
    this.addButton.setText("Add");
    this.addButton.setCursor(new Cursor(12));
    this.addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UsersPage.this.addButtonActionPerformed(evt);
          }
        });
    this.deleteButton.setText("Delete");
    this.deleteButton.setCursor(new Cursor(12));
    this.deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UsersPage.this.deleteButtonActionPerformed(evt);
          }
        });
    this.clearButton.setText("Clear");
    this.clearButton.setCursor(new Cursor(12));
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UsersPage.this.clearButtonActionPerformed(evt);
          }
        });
    GroupLayout entryPanelLayout = new GroupLayout(this.entryPanel);
    this.entryPanel.setLayout(entryPanelLayout);
    entryPanelLayout.setHorizontalGroup(entryPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(entryPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.userTypeCombo, 0, -1, 32767)
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel2, -2, 68, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.nameText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel3, -2, 68, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.locationText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel4, -2, 68, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.phoneText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel6, -2, 68, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.passText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel5, -2, 68, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.usernameText)))
          .addContainerGap())
        .addGroup(entryPanelLayout.createSequentialGroup()
          .addComponent(this.addButton, -2, 78, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.deleteButton, -2, 75, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.clearButton, -2, 75, -2)
          .addGap(0, 0, 32767)));
    entryPanelLayout.setVerticalGroup(entryPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(entryPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel2, -2, 25, -2)
            .addComponent(this.nameText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel3, -2, 25, -2)
            .addComponent(this.locationText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel4, -2, 25, -2)
            .addComponent(this.phoneText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel5, -2, 25, -2)
            .addComponent(this.usernameText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(this.jLabel6, -2, 25, -2)
            .addComponent(this.passText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addComponent(this.userTypeCombo, -2, 33, -2)
          .addGap(18, 18, 18)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.addButton)
            .addComponent(this.deleteButton)
            .addComponent(this.clearButton))
          .addContainerGap(-1, 32767)));
    this.userTable.setBorder(BorderFactory.createEtchedBorder());
    this.userTable.setForeground(new Color(102, 102, 102));
    this.userTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }) {
          boolean[] canEdit = new boolean[] { false, false, false, false };
          
          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
          }
        });
    this.userTable.setCursor(new Cursor(12));
    this.userTable.setName("Users");
    this.userTable.setShowGrid(true);
    this.userTable.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            UsersPage.this.userTableMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.userTable);
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jSeparator1)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -1, 432, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.entryPanel, -2, -1, -2))
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 62, -2)
              .addGap(0, 0, 32767)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.jLabel1, -2, 36, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.entryPanel, -1, -1, 32767)
            .addComponent(this.jScrollPane1, -2, 0, 32767))
          .addGap(95, 95, 95)));
  }
  
  private void clearButtonActionPerformed(ActionEvent evt) {
    this.nameText.setText("");
    this.locationText.setText("");
    this.phoneText.setText("");
    this.usernameText.setText("");
    this.passText.setText("");
  }
  
  private void addButtonActionPerformed(ActionEvent evt) {
    UserDTO userDTO = new UserDTO();
    if (this.nameText.getText().equals("") || this.locationText.getText().equals("") || this.phoneText.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
    } else {
      this.userType = (String)this.userTypeCombo.getSelectedItem();
      userDTO.setFullName(this.nameText.getText());
      userDTO.setLocation(this.locationText.getText());
      userDTO.setPhone(this.phoneText.getText());
      userDTO.setUsername(this.usernameText.getText());
      userDTO.setPassword(this.passText.getText());
      userDTO.setUserType(this.userType);
      (new UserDAO()).addUserDAO(userDTO, this.userType);
      loadDataSet();
    } 
  }
  
  private void deleteButtonActionPerformed(ActionEvent evt) {
    if (this.userTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(null, "Please select an entry from the table");
    } else {
      int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirmation", 0);
      if (opt == 0) {
        (new UserDAO()).deleteUserDAO(
            String.valueOf(this.userTable
              
              .getValueAt(this.userTable.getSelectedRow(), 4)));
        loadDataSet();
      } 
    } 
  }
  
  private void userTableMouseClicked(MouseEvent evt) {
    int row = this.userTable.getSelectedRow();
    int col = this.userTable.getColumnCount();
    Object[] val = new Object[col];
    for (int i = 0; i < col; i++)
      val[i] = this.userTable.getValueAt(row, i); 
    this.nameText.setText(val[1].toString());
    this.locationText.setText(val[2].toString());
    this.phoneText.setText(val[3].toString());
    this.usernameText.setText(val[4].toString());
    this.userTypeCombo.setSelectedItem(val[6].toString());
  }
  
  public void loadDataSet() {
    try {
      UserDAO userDAO = new UserDAO();
      this.userTable.setModel(userDAO.buildTableModel(userDAO.getQueryResult()));
    } catch (SQLException ex) {
      ex.printStackTrace();
    } 
  }
}
