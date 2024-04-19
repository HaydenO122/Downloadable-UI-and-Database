package com.inventory.UI;

import com.inventory.DAO.CustomerDAO;
import com.inventory.DTO.CustomerDTO;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class CustomerPage extends JPanel {
  private JButton addButton;
  
  private JButton clearButton;
  
  private JTextField codeText;
  
  private JTextField creditText;
  
  private JTable custTable;
  
  private JTextField debitText;
  
  private JButton deleteButton;
  
  private JButton editButton;
  
  private JPanel entryPanel;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JLabel jLabel8;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTextField locationText;
  
  private JTextField nameText;
  
  private JTextField phoneText;
  
  private JTextField searchText;
  
  public CustomerPage() {
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
    this.jLabel7 = new JLabel();
    this.phoneText = new JTextField();
    this.locationText = new JTextField();
    this.codeText = new JTextField();
    this.nameText = new JTextField();
    this.creditText = new JTextField();
    this.debitText = new JTextField();
    this.addButton = new JButton();
    this.editButton = new JButton();
    this.deleteButton = new JButton();
    this.clearButton = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.custTable = new JTable();
    this.searchText = new JTextField();
    this.jLabel8 = new JLabel();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("CUSTOMERS");
    this.entryPanel.setBorder(BorderFactory.createTitledBorder("Enter Customer Details"));
    this.jLabel2.setText("Customer Code:");
    this.jLabel3.setText("Full Name:");
    this.jLabel4.setText("Location:");
    this.jLabel5.setText("Contact:");
    this.jLabel6.setText("Debit Amount:");
    this.jLabel7.setText("Credit Amount:");
    this.addButton.setText("Add");
    this.addButton.setCursor(new Cursor(12));
    this.addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            CustomerPage.this.addButtonActionPerformed(evt);
          }
        });
    this.editButton.setText("Edit");
    this.editButton.setCursor(new Cursor(12));
    this.editButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            CustomerPage.this.editButtonActionPerformed(evt);
          }
        });
    this.deleteButton.setText("Delete");
    this.deleteButton.setCursor(new Cursor(12));
    this.deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            CustomerPage.this.deleteButtonActionPerformed(evt);
          }
        });
    this.clearButton.setFont(new Font("Segoe UI", 0, 14));
    this.clearButton.setText("CLEAR");
    this.clearButton.setCursor(new Cursor(12));
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            CustomerPage.this.clearButtonActionPerformed(evt);
          }
        });
    GroupLayout entryPanelLayout = new GroupLayout(this.entryPanel);
    this.entryPanel.setLayout(entryPanelLayout);
    entryPanelLayout.setHorizontalGroup(entryPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(entryPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.clearButton, -1, -1, 32767)
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(this.jLabel2, -1, -1, 32767)
                .addComponent(this.jLabel4, -1, -1, 32767)
                .addComponent(this.jLabel5, -1, -1, 32767)
                .addComponent(this.jLabel6, -1, -1, 32767)
                .addComponent(this.jLabel7, -1, -1, 32767)
                .addComponent(this.jLabel3, -1, -1, 32767))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.phoneText)
                .addComponent(this.creditText)
                .addComponent(this.debitText)
                .addComponent(this.locationText)
                .addComponent(this.codeText)
                .addComponent(this.nameText)))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.addButton)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.editButton)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.deleteButton)
              .addGap(0, 0, 32767)))
          .addContainerGap()));
    entryPanelLayout.setVerticalGroup(entryPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(entryPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel2, -2, 29, -2)
            .addComponent(this.codeText, -2, 29, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel3, -2, 29, -2)
            .addComponent(this.nameText, -2, 29, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel4, -2, 29, -2)
            .addComponent(this.locationText, -2, 29, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel5, -2, 29, -2)
            .addComponent(this.phoneText, -2, 29, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel6, -2, 29, -2)
            .addComponent(this.debitText, -2, 29, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel7, -2, 29, -2)
            .addComponent(this.creditText, -2, 29, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.addButton)
            .addComponent(this.editButton)
            .addComponent(this.deleteButton))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.clearButton, -2, 30, -2)
          .addContainerGap(18, 32767)));
    this.custTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.custTable.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            CustomerPage.this.custTableMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.custTable);
    this.searchText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            CustomerPage.this.searchTextKeyReleased(evt);
          }
        });
    this.jLabel8.setText("Search:");
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 122, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.jLabel8)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.searchText, -2, 181, -2))
            .addComponent(this.jSeparator1)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -1, 445, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.entryPanel, -2, -1, -2)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel1, -2, 40, -2)
            .addComponent(this.searchText, -2, -1, -2)
            .addComponent(this.jLabel8))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.entryPanel, -1, -1, 32767)
            .addComponent(this.jScrollPane1, -2, 0, 32767))
          .addContainerGap(67, 32767)));
  }
  
  private void addButtonActionPerformed(ActionEvent evt) {
    if (this.codeText.getText().equals("") || this.nameText.getText().equals("") || this.locationText
      .getText().equals("") || this.phoneText.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Please enter all the required details.");
    } else {
      CustomerDTO customerDTO = new CustomerDTO();
      customerDTO.setCustCode(this.codeText.getText());
      customerDTO.setFullName(this.nameText.getText());
      customerDTO.setLocation(this.locationText.getText());
      customerDTO.setPhone(this.phoneText.getText());
      (new CustomerDAO()).addCustomerDAO(customerDTO);
      loadDataSet();
    } 
  }
  
  private void editButtonActionPerformed(ActionEvent evt) {
    if (this.custTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(this, "Select a customer from the table.");
    } else if (this.codeText.getText().equals("") || this.nameText.getText().equals("") || this.locationText
      .getText().equals("") || this.phoneText.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Please enter all the required details.");
    } else {
      CustomerDTO customerDTO = new CustomerDTO();
      customerDTO.setCustCode(this.codeText.getText());
      customerDTO.setFullName(this.nameText.getText());
      customerDTO.setLocation(this.locationText.getText());
      customerDTO.setPhone(this.phoneText.getText());
      (new CustomerDAO()).editCustomerDAO(customerDTO);
      loadDataSet();
    } 
  }
  
  private void deleteButtonActionPerformed(ActionEvent evt) {
    if (this.custTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(this, "Select a customer from the table.");
    } else {
      int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Confirmation", 0);
      if (opt == 0) {
        (new CustomerDAO()).deleteCustomerDAO(this.custTable.getValueAt(this.custTable.getSelectedRow(), 0).toString());
        loadDataSet();
      } 
    } 
  }
  
  private void clearButtonActionPerformed(ActionEvent evt) {
    this.codeText.setText("");
    this.nameText.setText("");
    this.locationText.setText("");
    this.phoneText.setText("");
    this.searchText.setText("");
  }
  
  private void custTableMouseClicked(MouseEvent evt) {
    int row = this.custTable.getSelectedRow();
    int col = this.custTable.getColumnCount();
    Object[] data = new Object[col];
    for (int i = 0; i < col; i++)
      data[i] = this.custTable.getValueAt(row, i); 
    this.codeText.setText((String)data[0]);
    this.nameText.setText((String)data[1]);
    this.locationText.setText((String)data[2]);
    this.phoneText.setText((String)data[3]);
  }
  
  private void searchTextKeyReleased(KeyEvent evt) {
    loadSearchData(this.searchText.getText());
  }
  
  public void loadDataSet() {
    try {
      CustomerDAO customerDAO = new CustomerDAO();
      this.custTable.setModel(customerDAO.buildTableModel(customerDAO.getQueryResult()));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void loadSearchData(String text) {
    try {
      CustomerDAO customerDAO = new CustomerDAO();
      this.custTable.setModel(customerDAO.buildTableModel(customerDAO.getCustomerSearch(text)));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
