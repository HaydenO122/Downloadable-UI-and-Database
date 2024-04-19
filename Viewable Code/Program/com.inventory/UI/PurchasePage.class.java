package com.inventory.UI;

import com.inventory.DAO.ProductDAO;
import com.inventory.DAO.SupplierDAO;
import com.inventory.DTO.ProductDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class PurchasePage extends JPanel {
  ProductDTO productDTO;
  
  String username = null;
  
  String supplier = null;
  
  Dashboard dashboard;
  
  int quantity;
  
  String prodCode = null;
  
  private JButton addSuppButton;
  
  private JTextField brandText;
  
  private JButton clearButton;
  
  private JTextField codeText;
  
  private JTextField costText;
  
  private JButton deleteButton;
  
  private JDateChooser jDateChooser1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel10;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JLabel jLabel8;
  
  private JLabel jLabel9;
  
  private JPanel jPanel1;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTextField nameText;
  
  private JButton purchaseButton;
  
  private JTable purchaseTable;
  
  private JTextField quantityText;
  
  private JButton refreshButton;
  
  private JTextField searchText;
  
  private JTextField sellText;
  
  private JComboBox<String> suppCombo;
  
  public PurchasePage(Dashboard dashboard) {
    initComponents();
    this.dashboard = dashboard;
    loadComboBox();
    loadDataSet();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.jPanel1 = new JPanel();
    this.jLabel2 = new JLabel();
    this.suppCombo = new JComboBox<>();
    this.addSuppButton = new JButton();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.jLabel8 = new JLabel();
    this.jLabel9 = new JLabel();
    this.codeText = new JTextField();
    this.nameText = new JTextField();
    this.jDateChooser1 = new JDateChooser();
    this.quantityText = new JTextField();
    this.costText = new JTextField();
    this.sellText = new JTextField();
    this.brandText = new JTextField();
    this.purchaseButton = new JButton();
    this.deleteButton = new JButton();
    this.clearButton = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.purchaseTable = new JTable();
    this.refreshButton = new JButton();
    this.searchText = new JTextField();
    this.jLabel10 = new JLabel();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("PURCHASE");
    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Purchase Product"));
    this.jLabel2.setText("Supplier:");
    this.suppCombo.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    this.addSuppButton.setText("Click to add a new Supplier");
    this.addSuppButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            PurchasePage.this.addSuppButtonActionPerformed(evt);
          }
        });
    this.jLabel3.setText("Product Code:");
    this.jLabel4.setText("Product Name:");
    this.jLabel5.setText("Date:");
    this.jLabel6.setText("Quantity:");
    this.jLabel7.setText("Cost Price:");
    this.jLabel8.setText("Selling Price:");
    this.jLabel9.setText("Brand:");
    this.codeText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            PurchasePage.this.codeTextKeyReleased(evt);
          }
        });
    this.purchaseButton.setText("Purchase");
    this.purchaseButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            PurchasePage.this.purchaseButtonActionPerformed(evt);
          }
        });
    this.deleteButton.setText("Delete");
    this.deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            PurchasePage.this.deleteButtonActionPerformed(evt);
          }
        });
    this.clearButton.setText("CLEAR");
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            PurchasePage.this.clearButtonActionPerformed(evt);
          }
        });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.suppCombo, 0, -1, 32767)
                .addComponent(this.addSuppButton, -1, -1, 32767)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel3, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.codeText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel4, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.nameText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel5, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent((Component)this.jDateChooser1, -1, -1, 32767))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel6, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.quantityText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel7, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.costText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel8, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.sellText))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel2, -2, 62, -2)
                  .addGap(0, 0, 32767))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.jLabel9, -2, 102, -2)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.brandText))))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.purchaseButton, -2, 144, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.deleteButton, -1, 137, 32767))
            .addComponent(this.clearButton, -1, -1, 32767))
          .addContainerGap()));
    jPanel1Layout.setVerticalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap(12, 32767)
          .addComponent(this.jLabel2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.suppCombo, -2, 31, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.addSuppButton, -2, 33, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel3, -2, 26, -2)
                .addComponent(this.codeText, -2, -1, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel4, -2, 26, -2)
                .addComponent(this.nameText, -2, -1, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.jLabel5, -2, 26, -2))
            .addComponent((Component)this.jDateChooser1, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel6, -2, 26, -2)
            .addComponent(this.quantityText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel7, -2, 26, -2)
            .addComponent(this.costText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel8, -2, 26, -2)
            .addComponent(this.sellText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel9, -2, 26, -2)
            .addComponent(this.brandText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.deleteButton, -2, 31, -2)
            .addComponent(this.purchaseButton, -2, 31, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.clearButton)));
    this.purchaseTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.purchaseTable.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            PurchasePage.this.purchaseTableMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.purchaseTable);
    this.refreshButton.setFont(new Font("Segoe UI", 1, 12));
    this.refreshButton.setText("REFRESH");
    this.refreshButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            PurchasePage.this.refreshButtonActionPerformed(evt);
          }
        });
    this.searchText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            PurchasePage.this.searchTextKeyReleased(evt);
          }
        });
    this.jLabel10.setText("Search:");
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jSeparator1)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 112, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.jLabel10, -2, 50, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.searchText, -2, 139, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(this.refreshButton, -2, 99, -2))
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -1, 459, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.jPanel1, -2, -1, -2)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel1, -2, 43, -2)
            .addComponent(this.refreshButton)
            .addComponent(this.searchText, -2, -1, -2)
            .addComponent(this.jLabel10))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.jScrollPane1, -2, 0, 32767)
            .addComponent(this.jPanel1, -1, -1, 32767))
          .addContainerGap(28, 32767)));
  }
  
  private void refreshButtonActionPerformed(ActionEvent evt) {
    loadDataSet();
    loadComboBox();
    clearButtonActionPerformed(evt);
  }
  
  private void addSuppButtonActionPerformed(ActionEvent evt) {
    this.dashboard.addSuppPage();
  }
  
  private void purchaseButtonActionPerformed(ActionEvent evt) {
    this.productDTO = new ProductDTO();
    if (this.codeText.getText().equals("") || this.jDateChooser1.getDate() == null || this.quantityText
      .getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Please enter all the required details.");
    } else {
      this.productDTO.setSuppCode((new ProductDAO()).getSuppCode(this.suppCombo.getSelectedItem().toString()));
      this.productDTO.setProdCode(this.codeText.getText());
      try {
        ResultSet resultSet = (new ProductDAO()).getProdName(this.codeText.getText());
        if (resultSet.next()) {
          this.productDTO.setDate(this.jDateChooser1.getDate().toString());
          this.productDTO.setQuantity(Integer.parseInt(this.quantityText.getText()));
          Double costPrice = Double.valueOf(Double.parseDouble(this.costText.getText()));
          Double totalCost = Double.valueOf(costPrice.doubleValue() * Integer.parseInt(this.quantityText.getText()));
          this.productDTO.setTotalCost(totalCost);
          (new ProductDAO()).addPurchaseDAO(this.productDTO);
          loadDataSet();
        } else {
          JOptionPane.showMessageDialog(null, "This seems to be a new product that hasn't been added yet.\nPlease add this product in the \"Products\" section before proceeding.");
        } 
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  private void deleteButtonActionPerformed(ActionEvent evt) {
    if (this.purchaseTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(null, "Please select a transaction from the table.");
    } else {
      int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this purchase?", "Confirmation", 0);
      if (opt == 0) {
        (new ProductDAO()).deletePurchaseDAO(((Integer)this.purchaseTable.getValueAt(this.purchaseTable.getSelectedRow(), 0)).intValue());
        (new ProductDAO()).editPurchaseStock(this.prodCode, this.quantity);
        loadDataSet();
      } 
    } 
  }
  
  private void clearButtonActionPerformed(ActionEvent evt) {
    this.codeText.setText("");
    this.nameText.setText("");
    this.jDateChooser1.setDate(null);
    this.quantityText.setText("");
    this.costText.setText("");
    this.sellText.setText("");
    this.brandText.setText("");
    this.searchText.setText("");
  }
  
  private void searchTextKeyReleased(KeyEvent evt) {
    loadSearchData(this.searchText.getText());
  }
  
  private void purchaseTableMouseClicked(MouseEvent evt) {
    int row = this.purchaseTable.getSelectedRow();
    int col = this.purchaseTable.getColumnCount();
    Object[] data = new Object[col];
    for (int i = 0; i < col; i++)
      data[i] = this.purchaseTable.getValueAt(row, i); 
    this.quantity = Integer.parseInt(data[3].toString());
    this.prodCode = data[1].toString();
  }
  
  private void codeTextKeyReleased(KeyEvent evt) {
    try {
      ResultSet resultSet = (new ProductDAO()).getProdFromCode(this.codeText.getText());
      if (resultSet.next()) {
        this.nameText.setText(resultSet.getString("productname"));
        this.costText.setText(String.valueOf(resultSet.getDouble("costprice")));
        this.sellText.setText(String.valueOf(resultSet.getDouble("sellprice")));
        this.brandText.setText(resultSet.getString("brand"));
      } else {
        this.nameText.setText("");
        this.costText.setText("");
        this.sellText.setText("");
        this.brandText.setText("");
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void loadComboBox() {
    try {
      SupplierDAO supplierDAO = new SupplierDAO();
      this.suppCombo.setModel(supplierDAO.setComboItems(supplierDAO.getQueryResult()));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void loadDataSet() {
    try {
      ProductDAO productDAO = new ProductDAO();
      this.purchaseTable.setModel(productDAO.buildTableModel(productDAO.getPurchaseInfo()));
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }
  
  public void loadSearchData(String text) {
    try {
      ProductDAO productDAO = new ProductDAO();
      this.purchaseTable.setModel(productDAO.buildTableModel(productDAO.getPurchaseSearch(text)));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
