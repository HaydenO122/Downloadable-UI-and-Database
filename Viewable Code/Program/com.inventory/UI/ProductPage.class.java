package com.inventory.UI;

import com.inventory.DAO.ProductDAO;
import com.inventory.DAO.SupplierDAO;
import com.inventory.DTO.ProductDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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

public class ProductPage extends JPanel {
  ProductDTO productDTO;
  
  String username = null;
  
  String supplier = null;
  
  int userID;
  
  Dashboard dashboard;
  
  private JButton addButton;
  
  private JButton addSuppButton;
  
  private JTextField brandText;
  
  private JButton clearButton;
  
  private JTextField codeText;
  
  private JTextField costText;
  
  private JButton deleteButton;
  
  private JButton editButton;
  
  private JPanel entryPanel;
  
  private JDateChooser jDateChooser1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JLabel jLabel8;
  
  private JLabel jLabel9;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JTextField nameText;
  
  private JTable productTable;
  
  private JTextField quantityText;
  
  private JButton refreshButton;
  
  private JTextField searchText;
  
  private JTextField sellText;
  
  private JComboBox<String> suppCombo;
  
  public ProductPage() {}
  
  public ProductPage(String username, Dashboard dashboard) {
    initComponents();
    this.username = username;
    this.dashboard = dashboard;
    loadComboBox();
    loadDataSet();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.entryPanel = new JPanel();
    this.suppCombo = new JComboBox<>();
    this.addSuppButton = new JButton();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.jLabel8 = new JLabel();
    this.codeText = new JTextField();
    this.nameText = new JTextField();
    this.jDateChooser1 = new JDateChooser();
    this.quantityText = new JTextField();
    this.costText = new JTextField();
    this.sellText = new JTextField();
    this.brandText = new JTextField();
    this.addButton = new JButton();
    this.editButton = new JButton();
    this.deleteButton = new JButton();
    this.clearButton = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.productTable = new JTable();
    this.refreshButton = new JButton();
    this.searchText = new JTextField();
    this.jLabel9 = new JLabel();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("PRODUCTS");
    this.entryPanel.setBorder(BorderFactory.createTitledBorder("Enter Product Details"));
    this.suppCombo.setModel(new DefaultComboBoxModel<>(new String[] { "Select a supplier" }));
    this.suppCombo.setToolTipText("Select a supplier");
    this.addSuppButton.setText("Click to add a New Supplier");
    this.addSuppButton.setCursor(new Cursor(12));
    this.addSuppButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            ProductPage.this.addSuppButtonActionPerformed(evt);
          }
        });
    this.jLabel2.setText("Product Code:");
    this.jLabel3.setText("Product Name:");
    this.jLabel4.setText("Date:");
    this.jLabel5.setText("Quantity:");
    this.jLabel6.setText("Cost Price:");
    this.jLabel7.setText("Selling Price:");
    this.jLabel8.setText("Brand:");
    this.jDateChooser1.setForeground(new Color(102, 102, 102));
    this.addButton.setText("Add");
    this.addButton.setCursor(new Cursor(12));
    this.addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            ProductPage.this.addButtonActionPerformed(evt);
          }
        });
    this.editButton.setText("Edit");
    this.editButton.setCursor(new Cursor(12));
    this.editButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            ProductPage.this.editButtonActionPerformed(evt);
          }
        });
    this.deleteButton.setText("Delete");
    this.deleteButton.setCursor(new Cursor(12));
    this.deleteButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            ProductPage.this.deleteButtonActionPerformed(evt);
          }
        });
    this.clearButton.setFont(new Font("Segoe UI", 0, 14));
    this.clearButton.setText("CLEAR");
    this.clearButton.setCursor(new Cursor(12));
    this.clearButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            ProductPage.this.clearButtonActionPerformed(evt);
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
            .addComponent(this.suppCombo, 0, -1, 32767)
            .addComponent(this.addSuppButton, -1, -1, 32767)
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel2, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.codeText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel3, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.nameText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel8, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.brandText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel4, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent((Component)this.jDateChooser1, -1, -1, 32767))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel5, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.quantityText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel6, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.costText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.jLabel7, -2, 84, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.sellText))
            .addGroup(entryPanelLayout.createSequentialGroup()
              .addComponent(this.addButton)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.editButton, -2, 78, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.deleteButton, -1, 75, 32767)))
          .addContainerGap()));
    entryPanelLayout.setVerticalGroup(entryPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(entryPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.suppCombo, -2, 31, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.addSuppButton, -2, 30, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel2, -2, 26, -2)
            .addComponent(this.codeText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel3, -2, 26, -2)
            .addComponent(this.nameText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent((Component)this.jDateChooser1, -1, 26, 32767)
            .addComponent(this.jLabel4, -1, -1, 32767))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel5, -2, 26, -2)
            .addComponent(this.quantityText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel6, -2, 26, -2)
            .addComponent(this.costText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel7, -2, 26, -2)
            .addComponent(this.sellText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel8, -2, 26, -2)
            .addComponent(this.brandText, -2, 26, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.addButton)
            .addComponent(this.editButton)
            .addComponent(this.deleteButton))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.clearButton)
          .addContainerGap(-1, 32767)));
    this.productTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.productTable.setCursor(new Cursor(12));
    this.productTable.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            ProductPage.this.productTableMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.productTable);
    this.refreshButton.setFont(new Font("Segoe UI", 1, 12));
    this.refreshButton.setText("REFRESH");
    this.refreshButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            ProductPage.this.refreshButtonActionPerformed(evt);
          }
        });
    this.searchText.addKeyListener(new KeyAdapter() {
          public void keyReleased(KeyEvent evt) {
            ProductPage.this.searchTextKeyReleased(evt);
          }
        });
    this.jLabel9.setText("Search:");
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 126, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.jLabel9)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.searchText, -2, 158, -2)
              .addGap(18, 18, 18)
              .addComponent(this.refreshButton))
            .addComponent(this.jSeparator1)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -1, 496, 32767)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.entryPanel, -2, -1, -2)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(this.jLabel1, -2, 41, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addContainerGap(-1, 32767)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.refreshButton, -2, 29, -2)
                .addComponent(this.searchText, -2, -1, -2)
                .addComponent(this.jLabel9))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.entryPanel, -1, -1, 32767)
            .addComponent(this.jScrollPane1, -2, 0, 32767))
          .addGap(64, 64, 64)));
  }
  
  private void editButtonActionPerformed(ActionEvent evt) {
    if (this.productTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(null, "Please select product from the table.");
    } else {
      this.productDTO = new ProductDTO();
      if (this.nameText.getText().equals("") || this.costText.getText().equals("") || this.sellText
        .getText().equals("") || this.brandText.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please enter all the required details.");
      } else {
        this.productDTO.setProdCode(this.codeText.getText());
        this.productDTO.setProdName(this.nameText.getText());
        this.productDTO.setDate(this.jDateChooser1.getDateFormatString());
        this.productDTO.setQuantity(Integer.parseInt(this.quantityText.getText()));
        this.productDTO.setCostPrice(Double.parseDouble(this.costText.getText()));
        this.productDTO.setSellPrice(Double.parseDouble(this.sellText.getText()));
        this.productDTO.setBrand(this.brandText.getText());
        this.productDTO.setUserID(this.userID);
        (new ProductDAO()).editProdDAO(this.productDTO);
      } 
      loadDataSet();
    } 
  }
  
  private void addButtonActionPerformed(ActionEvent evt) {
    this.productDTO = new ProductDTO();
    if (this.nameText.getText().equals("") || this.costText.getText().equals("") || this.sellText
      .getText().equals("") || this.brandText.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Please enter all the required details.");
    } else {
      this.productDTO.setProdCode(this.codeText.getText());
      this.productDTO.setProdName(this.nameText.getText());
      this.productDTO.setDate(this.jDateChooser1.getDateFormatString());
      this.productDTO.setQuantity(Integer.parseInt(this.quantityText.getText()));
      this.productDTO.setCostPrice(Double.parseDouble(this.costText.getText()));
      this.productDTO.setSellPrice(Double.parseDouble(this.sellText.getText()));
      this.productDTO.setBrand(this.brandText.getText());
      this.productDTO.setUserID(this.userID);
      (new ProductDAO()).addProductDAO(this.productDTO);
      loadDataSet();
    } 
  }
  
  private void deleteButtonActionPerformed(ActionEvent evt) {
    if (this.productTable.getSelectedRow() < 0) {
      JOptionPane.showMessageDialog(null, "Please select product from the table.");
    } else {
      int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?", "Confirmation", 0);
      if (opt == 0) {
        (new ProductDAO()).deleteProductDAO((String)this.productTable
            .getValueAt(this.productTable
              .getSelectedRow(), 0));
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
  
  private void productTableMouseClicked(MouseEvent evt) {
    int row = this.productTable.getSelectedRow();
    int col = this.productTable.getColumnCount();
    Object[] data = new Object[col];
    for (int i = 0; i < col; i++)
      data[i] = this.productTable.getValueAt(row, i); 
    this.codeText.setText(data[0].toString());
    this.nameText.setText(data[1].toString());
    this.costText.setText(data[2].toString());
    this.sellText.setText(data[3].toString());
    this.brandText.setText(data[4].toString());
  }
  
  private void addSuppButtonActionPerformed(ActionEvent evt) {
    this.dashboard.addSuppPage();
  }
  
  private void refreshButtonActionPerformed(ActionEvent evt) {
    loadDataSet();
    loadComboBox();
    clearButtonActionPerformed(evt);
  }
  
  private void searchTextKeyReleased(KeyEvent evt) {
    loadSearchData(this.searchText.getText());
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
      this.productTable.setModel(productDAO.buildTableModel(productDAO.getQueryResult()));
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }
  
  public void loadSearchData(String text) {
    try {
      ProductDAO productDAO = new ProductDAO();
      this.productTable.setModel(productDAO.buildTableModel(productDAO.getProductSearch(text)));
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }
}
