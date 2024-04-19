package com.inventory.UI;

import com.inventory.DAO.CustomerDAO;
import com.inventory.DAO.ProductDAO;
import com.inventory.DTO.ProductDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
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

public class SalesPage extends JPanel {
  String username;
  
  Dashboard dashboard;
  
  int quantity;
  
  String prodCode;
  
  private JButton addCustButton;
  
  private JButton clearButton;
  
  private JTextField custCodeText;
  
  private JLabel custNameLabel;
  
  private JButton deleteButton;
  
  private JDateChooser jDateChooser1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTextField priceText;
  
  private JTextField prodCodeText;
  
  private JLabel prodNameLabel;
  
  private JTextField quantityText;
  
  private JTable salesTable;
  
  private JTextField searchText;
  
  private JButton sellButton;
  
  private JPanel sellPanel;
  
  public SalesPage(String username, Dashboard dashboard) {
    initComponents();
    this.username = username;
    this.dashboard = dashboard;
    this.custNameLabel.setVisible(false);
    this.prodNameLabel.setVisible(false);
    loadDataSet();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.sellPanel = new JPanel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.custCodeText = new JTextField();
    this.prodCodeText = new JTextField();
    this.priceText = new JTextField();
    this.quantityText = new JTextField();
    this.jDateChooser1 = new JDateChooser();
    this.sellButton = new JButton();
    this.deleteButton = new JButton();
    this.clearButton = new JButton();
    this.addCustButton = new JButton();
    this.custNameLabel = new JLabel();
    this.prodNameLabel = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.salesTable = new JTable();
    this.searchText = new JTextField();
    this.jLabel7 = new JLabel();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("SALES");
    this.sellPanel.setBorder(BorderFactory.createTitledBorder("Sell Product"));
    this.jLabel2.setText("Customer Code:");
    this.jLabel3.setText("Product Code:");
    this.jLabel4.setText("Date:");
    this.jLabel5.setText("Selling Price:");
    this.jLabel6.setText("Quantity:");
    this.custCodeText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            SalesPage.this.custCodeTextKeyReleased(evt);
          }
        });
    this.prodCodeText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            SalesPage.this.prodCodeTextKeyReleased(evt);
          }
        });
    this.sellButton.setFont(new Font("Segoe UI", 1, 12));
    this.sellButton.setText("SELL PRODUCT");
    this.sellButton.setCursor(new Cursor(12));
    this.sellButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SalesPage.this.sellButtonActionPerformed(evt);
          }
        });
    this.deleteButton.setText("Delete");
    this.deleteButton.setCursor(new Cursor(12));
    this.deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SalesPage.this.deleteButtonActionPerformed(evt);
          }
        });
    this.clearButton.setText("Clear");
    this.clearButton.setCursor(new Cursor(12));
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SalesPage.this.clearButtonActionPerformed(evt);
          }
        });
    this.addCustButton.setText("Click to add a New Customer");
    this.addCustButton.setCursor(new Cursor(12));
    this.addCustButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            SalesPage.this.addCustButtonActionPerformed(evt);
          }
        });
    this.custNameLabel.setHorizontalAlignment(0);
    this.custNameLabel.setLabelFor(this.custCodeText);
    this.prodNameLabel.setHorizontalAlignment(0);
    this.prodNameLabel.setLabelFor(this.prodCodeText);
    GroupLayout sellPanelLayout = new GroupLayout(this.sellPanel);
    this.sellPanel.setLayout(sellPanelLayout);
    sellPanelLayout.setHorizontalGroup(sellPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(sellPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.prodNameLabel, -1, -1, 32767)
            .addComponent(this.custNameLabel, -1, -1, 32767)
            .addComponent(this.addCustButton, -1, -1, 32767)
            .addComponent(this.sellButton, -1, -1, 32767)
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel2, -2, 86, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.custCodeText))
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel3, -2, 86, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.prodCodeText))
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addComponent(this.deleteButton, -2, 134, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.clearButton, -1, 129, 32767))
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel6, -2, 86, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.quantityText))
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel5, -2, 86, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.priceText))
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel4, -2, 86, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent((Component)this.jDateChooser1, -1, -1, 32767)))
          .addContainerGap()));
    sellPanelLayout.setVerticalGroup(sellPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(sellPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jLabel2, -2, 24, -2)
            .addGroup(sellPanelLayout.createSequentialGroup()
              .addGap(1, 1, 1)
              .addComponent(this.custCodeText, -2, 29, -2)))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.custNameLabel, -2, 26, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767)
          .addComponent(this.addCustButton)
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.jLabel3, -1, -1, 32767)
            .addComponent(this.prodCodeText, -1, 24, 32767))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.prodNameLabel, -2, 33, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767)
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jLabel4, -2, 24, -2)
            .addComponent((Component)this.jDateChooser1, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel5, -2, 24, -2)
            .addComponent(this.priceText, -2, 24, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jLabel6, -2, 30, -2)
            .addComponent(this.quantityText, -2, 24, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.sellButton, -2, 33, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.deleteButton)
            .addComponent(this.clearButton))
          .addContainerGap()));
    this.salesTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.salesTable.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            SalesPage.this.salesTableMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.salesTable);
    this.searchText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            SalesPage.this.searchTextKeyReleased(evt);
          }
        });
    this.jLabel7.setText("Search:");
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 70, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.jLabel7)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.searchText, -2, 174, -2))
            .addComponent(this.jSeparator1)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -1, 457, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.sellPanel, -2, -1, -2)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel1, -2, 40, -2)
            .addComponent(this.searchText, -2, -1, -2)
            .addComponent(this.jLabel7))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.sellPanel, -1, -1, 32767)
            .addComponent(this.jScrollPane1, -2, 0, 32767))
          .addContainerGap(70, 32767)));
  }
  
  private void deleteButtonActionPerformed(ActionEvent evt) {
    if (this.salesTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(this, "Please select an entry from the table you wish to delete.");
    } else {
      int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this sale from the database?", "Confirmation", 0);
      if (opt == 0) {
        (new ProductDAO()).deleteSaleDAO(Integer.parseInt(this.salesTable
              .getValueAt(this.salesTable.getSelectedRow(), 0).toString()));
        (new ProductDAO()).editSoldStock(this.salesTable
            .getValueAt(this.salesTable.getSelectedRow(), 1).toString(), this.quantity);
        loadDataSet();
      } 
    } 
  }
  
  private void clearButtonActionPerformed(ActionEvent evt) {
    this.custCodeText.setText("");
    this.custNameLabel.setText("");
    this.custNameLabel.setVisible(false);
    this.prodCodeText.setText("");
    this.prodNameLabel.setText("");
    this.prodNameLabel.setVisible(false);
    this.jDateChooser1.setDate(null);
    this.priceText.setText("");
    this.quantityText.setText("");
    loadDataSet();
  }
  
  private void addCustButtonActionPerformed(ActionEvent evt) {
    this.dashboard.addCustPage();
  }
  
  private void sellButtonActionPerformed(ActionEvent evt) {
    if (this.custCodeText.getText().equals("") || this.prodCodeText.getText().equals("") || this.jDateChooser1
      .getDate() == null || this.quantityText.getText().equals("") || this.priceText.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Please fill all the required fields.");
    } else {
      try {
        ResultSet resultSet = (new CustomerDAO()).getCustName(this.custCodeText.getText());
        if (resultSet.next()) {
          ProductDTO productDTO = new ProductDTO();
          productDTO.setCustCode(this.custCodeText.getText());
          productDTO.setDate(this.jDateChooser1.getDate().toString());
          productDTO.setProdCode(this.prodCodeText.getText());
          Double sellPrice = Double.valueOf(Double.parseDouble(this.priceText.getText()));
          Double totalRevenue = Double.valueOf(sellPrice.doubleValue() * Integer.parseInt(this.quantityText.getText()));
          productDTO.setTotalRevenue(totalRevenue);
          productDTO.setQuantity(Integer.parseInt(this.quantityText.getText()));
          (new ProductDAO()).sellProductDAO(productDTO, this.username);
          loadDataSet();
        } else {
          JOptionPane.showMessageDialog(this, "This customer does not exist.\nAdd new customer or use a valid customer code.");
        } 
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  private void salesTableMouseClicked(MouseEvent evt) {
    int row = this.salesTable.getSelectedRow();
    int col = this.salesTable.getColumnCount();
    Object[] data = new Object[col];
    for (int i = 0; i < col; i++)
      data[i] = this.salesTable.getValueAt(row, i); 
    this.quantity = Integer.parseInt(data[3].toString());
    this.prodCode = data[1].toString();
  }
  
  private void custCodeTextKeyReleased(KeyEvent evt) {
    try {
      ResultSet resultSet = (new CustomerDAO()).getCustName(this.custCodeText.getText());
      if (resultSet.next()) {
        this.custNameLabel.setText("Name: " + resultSet
            .getString("fullname") + " | Location: " + resultSet
            
            .getString("location"));
      } else {
        this.custNameLabel.setText("||   Customer doesn't exist in database.   ||");
      } 
      this.custNameLabel.setVisible(true);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void prodCodeTextKeyReleased(KeyEvent evt) {
    try {
      ResultSet resultSet = (new CustomerDAO()).getProdName(this.prodCodeText.getText());
      if (resultSet.next()) {
        this.prodNameLabel.setText("Name: " + resultSet
            .getString("productname") + " | Available quantity: " + resultSet
            
            .getString("quantity"));
        Double sellPrice = (new ProductDAO()).getProdSell(this.prodCodeText.getText());
        this.priceText.setText(sellPrice.toString());
      } else {
        this.prodNameLabel.setText("||   Product doesn't exist in Inventory.  ||");
      } 
      this.prodNameLabel.setVisible(true);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void searchTextKeyReleased(KeyEvent evt) {
    loadSearchData(this.searchText.getText());
  }
  
  public void loadDataSet() {
    try {
      ProductDAO productDAO = new ProductDAO();
      this.salesTable.setModel(productDAO.buildTableModel(productDAO.getSalesInfo()));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void loadSearchData(String text) {
    try {
      ProductDAO productDAO = new ProductDAO();
      this.salesTable.setModel(productDAO.buildTableModel(productDAO.getSalesSearch(text)));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
