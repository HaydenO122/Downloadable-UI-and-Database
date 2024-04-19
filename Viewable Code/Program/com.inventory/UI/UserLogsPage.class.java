package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class UserLogsPage extends JPanel {
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTable logTable;
  
  private JButton refreshButton;
  
  private JTextField searchText;
  
  public UserLogsPage() {
    initComponents();
    loadDataSet();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.jScrollPane1 = new JScrollPane();
    this.logTable = new JTable();
    this.refreshButton = new JButton();
    this.searchText = new JTextField();
    this.jLabel2 = new JLabel();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("USER LOGS");
    this.logTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.jScrollPane1.setViewportView(this.logTable);
    this.refreshButton.setFont(new Font("Segoe UI", 1, 12));
    this.refreshButton.setText("REFRESH");
    this.refreshButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UserLogsPage.this.refreshButtonActionPerformed(evt);
          }
        });
    this.searchText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            UserLogsPage.this.searchTextKeyReleased(evt);
          }
        });
    this.jLabel2.setText("Search:");
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jSeparator1)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jScrollPane1, -1, 672, 32767)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 129, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.jLabel2, -2, 48, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.searchText, -2, 153, -2)
              .addGap(18, 18, 18)
              .addComponent(this.refreshButton, -2, 89, -2)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
              .addComponent(this.refreshButton)
              .addComponent(this.searchText, -2, -1, -2)
              .addComponent(this.jLabel2))
            .addComponent(this.jLabel1, -2, 40, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jScrollPane1, -2, 407, -2)
          .addContainerGap(26, 32767)));
  }
  
  private void searchTextKeyReleased(KeyEvent evt) {}
  
  private void refreshButtonActionPerformed(ActionEvent evt) {
    loadDataSet();
  }
  
  public void loadDataSet() {
    try {
      UserDAO userDAO = new UserDAO();
      this.logTable.setModel(userDAO.buildTableModel(userDAO.getUserLogsDAO()));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
