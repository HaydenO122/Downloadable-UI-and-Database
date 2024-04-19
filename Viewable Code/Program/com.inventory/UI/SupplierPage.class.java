package com.inventory.UI;

import com.inventory.DAO.SupplierDAO;
import com.inventory.DTO.SupplierDTO;
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

//
// This code creates the SupplierPage and adds the buttons from supplier$# class.
//
public class SupplierPage extends JPanel {
  private JButton addButton;
  
  private JButton clearButton;
  
  private JTextField codeText;
  
  private JTextField creditText;
  
  private JTextField debitText;
  
  private JButton deleteButton;
  
  private JButton editButton;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JLabel jLabel8;
  
  private JPanel jPanel1;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTextField locationText;
  
  private JTextField nameText;
  
  private JTextField phoneText;
  
  private JTextField searchText;
  
  private JTable suppTable;
  
  public SupplierPage() {
    initComponents();
    loadDataSet();
  }

  //
  // This code formats the location layout of buttons and text within the supplier page.
  //
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.jPanel1 = new JPanel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.creditText = new JTextField();
    this.codeText = new JTextField();
    this.nameText = new JTextField();
    this.phoneText = new JTextField();
    this.locationText = new JTextField();
    this.debitText = new JTextField();
    this.addButton = new JButton();
    this.deleteButton = new JButton();
    this.editButton = new JButton();
    this.clearButton = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.suppTable = new JTable();
    this.searchText = new JTextField();
    this.jLabel8 = new JLabel();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("SUPPLIERS");
    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Enter Supplier Details"));
    this.jLabel2.setText("Supplier Code:");
    this.jLabel3.setText("Full Name:");
    this.jLabel4.setText("Location:");
    this.jLabel5.setText("Contact:");
    this.jLabel6.setText("Debit Amount:");
    this.jLabel7.setText("Credit Amount:");
    this.addButton.setText("Add");
    this.addButton.setCursor(new Cursor(12));
    this.addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SupplierPage.this.addButtonActionPerformed(evt);
          }
        });
    this.deleteButton.setText("Delete");
    this.deleteButton.setCursor(new Cursor(12));
    this.deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SupplierPage.this.deleteButtonActionPerformed(evt);
          }
        });
    this.editButton.setText("Edit");
    this.editButton.setCursor(new Cursor(12));
    this.editButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SupplierPage.this.editButtonActionPerformed(evt);
          }
        });
    this.clearButton.setFont(new Font("Segoe UI", 0, 14));
    this.clearButton.setText("CLEAR");
    this.clearButton.setCursor(new Cursor(12));
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SupplierPage.this.clearButtonActionPerformed(evt);
          }
        });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.clearButton, -1, -1, 32767)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.jLabel7, -2, 89, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.creditText))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.jLabel2, -2, 89, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.codeText))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.jLabel6, -2, 89, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.debitText))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.jLabel5, -2, 89, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.phoneText))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.jLabel4, -2, 89, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.locationText))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.jLabel3, -2, 89, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.nameText))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.addButton, -2, 78, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.editButton, -1, 79, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.deleteButton, -2, 78, -2)))
          .addContainerGap()));
    jPanel1Layout.setVerticalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel2, -2, 26, -2)
            .addComponent(this.codeText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel3, -2, 26, -2)
            .addComponent(this.nameText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel4, -2, 26, -2)
            .addComponent(this.locationText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel5, -2, 26, -2)
            .addComponent(this.phoneText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel6, -2, 26, -2)
            .addComponent(this.debitText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel7, -2, 26, -2)
            .addComponent(this.creditText, -2, 26, -2))
          .addGap(18, 18, 18)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.addButton)
            .addComponent(this.deleteButton)
            .addComponent(this.editButton))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.clearButton)
          .addContainerGap(-1, 32767)));
    this.suppTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.suppTable.setCursor(new Cursor(12));
    this.suppTable.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            SupplierPage.this.suppTableMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.suppTable);
    this.searchText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            SupplierPage.this.searchTextKeyReleased(evt);
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
            .addComponent(this.jSeparator1)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 111, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.jLabel8)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.searchText, -2, 170, -2))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -1, 479, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.jPanel1, -2, -1, -2)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel1, -2, 42, -2)
            .addComponent(this.searchText, -2, -1, -2)
            .addComponent(this.jLabel8))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jPanel1, -1, -1, 32767)
            .addComponent(this.jScrollPane1, -2, 0, 32767))
          .addContainerGap(31, 32767)));
  }
  
  private void suppTableMouseClicked(MouseEvent evt) {
    int row = this.suppTable.getSelectedRow();
    int col = this.suppTable.getColumnCount();
    Object[] data = new Object[col];
    for (int i = 0; i < col; i++)
      data[i] = this.suppTable.getValueAt(row, i); 
    this.codeText.setText((String)data[0]);
    this.nameText.setText((String)data[1]);
    this.locationText.setText((String)data[2]);
    this.phoneText.setText((String)data[3]);
  }
  
  private void addButtonActionPerformed(ActionEvent evt) {
    if (this.codeText.getText().equals("") || this.nameText.getText().equals("") || this.locationText
      .getText().equals("") || this.phoneText.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Please enter all the required details.");
    } else {
      SupplierDTO supplierDTO = new SupplierDTO();
      supplierDTO.setSuppCode(this.codeText.getText());
      supplierDTO.setFullName(this.nameText.getText());
      supplierDTO.setLocation(this.locationText.getText());
      supplierDTO.setPhone(this.phoneText.getText());
      (new SupplierDAO()).addSupplierDAO(supplierDTO);
      loadDataSet();
    } 
  }
  
  private void editButtonActionPerformed(ActionEvent evt) {
    if (this.suppTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(this, "Please select an entry to edit from the table.");
    } else if (this.codeText.getText().equals("") || this.nameText.getText().equals("") || this.locationText
      .getText().equals("") || this.phoneText.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Please enter all the required details.");
    } else {
      SupplierDTO supplierDTO = new SupplierDTO();
      supplierDTO.setSuppCode(this.codeText.getText());
      supplierDTO.setFullName(this.nameText.getText());
      supplierDTO.setLocation(this.locationText.getText());
      supplierDTO.setPhone(this.phoneText.getText());
      (new SupplierDAO()).editSupplierDAO(supplierDTO);
      loadDataSet();
    } 
  }
  
  private void deleteButtonActionPerformed(ActionEvent evt) {
    if (this.suppTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(this, "Please select an entry from the table to be deleted.");
    } else {
      int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this supplier?", "Confirmation", 0);
      if (opt == 0) {
        (new SupplierDAO()).deleteSupplierDAO(this.suppTable.getValueAt(this.suppTable.getSelectedRow(), 0).toString());
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
  
  private void searchTextKeyReleased(KeyEvent evt) {
    String text = this.searchText.getText();
    loadSearchData(text);
  }
  
  public void loadDataSet() {
    try {
      SupplierDAO supplierDAO = new SupplierDAO();
      this.suppTable.setModel(supplierDAO.buildTableModel(supplierDAO.getQueryResult()));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void loadSearchData(String text) {
    try {
      SupplierDAO supplierDAO = new SupplierDAO();
      this.suppTable.setModel(supplierDAO.buildTableModel(supplierDAO.getSearchResult(text)));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
