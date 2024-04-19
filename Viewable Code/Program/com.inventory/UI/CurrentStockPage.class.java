package com.inventory.UI;

import com.inventory.DAO.ProductDAO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class CurrentStockPage extends JPanel {
  String username;
  
  private JLabel jLabel1;
  
  private JScrollPane jScrollPane1;
  
  private JSeparator jSeparator1;
  
  private JButton refreshButton;
  
  private JTable stockTable;
  
  public CurrentStockPage(String username) {
    initComponents();
    this.username = username;
    loadDataSet();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.jScrollPane1 = new JScrollPane();
    this.stockTable = new JTable();
    this.refreshButton = new JButton();
    this.jLabel1.setFont(new Font("Impact", 0, 24));
    this.jLabel1.setText("CURRENT STOCK");
    this.jLabel1.setToolTipText("");
    this.stockTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.jScrollPane1.setViewportView(this.stockTable);
    this.refreshButton.setFont(new Font("Segoe UI", 1, 12));
    this.refreshButton.setText("REFRESH");
    this.refreshButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            CurrentStockPage.this.refreshButtonActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(this.jSeparator1)
            .addComponent(this.jScrollPane1, -1, 701, 32767)
            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
              .addComponent(this.jLabel1, -2, 165, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
              .addComponent(this.refreshButton)))
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(this.refreshButton, -2, 31, -2)
            .addComponent(this.jLabel1, -2, 44, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
          .addComponent(this.jSeparator1, -2, 10, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jScrollPane1, -2, 330, -2)
          .addContainerGap(88, 32767)));
  }
  
  private void refreshButtonActionPerformed(ActionEvent evt) {
    loadDataSet();
  }
  
  public void loadDataSet() {
    try {
      ProductDAO productDAO = new ProductDAO();
      this.stockTable.setModel(productDAO.buildTableModel(productDAO.getCurrentStockInfo()));
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
