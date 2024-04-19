//
// Takes group of classes from inventory.
//

package com.inventory.DAO;

//
// Imports sql data and java/sql connector.
//

import com.inventory.DTO.ProductDTO;
import com.inventory.Database.ConnectionFactory;
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

//
// Creates a public class "ProductDAO" that displays the database information for products.
//

public class ProductDAO {
  Connection conn = null;
  
  PreparedStatement prepStatement = null;
  
  PreparedStatement prepStatement2 = null;
  
  Statement statement = null;
  
  Statement statement2 = null;
  
  ResultSet resultSet = null;
  
  String suppCode;
  
  String prodCode;
  
  String custCode;
  
  boolean flag;
  
  //
  //Takes result information from suppliers and returns what is taken.
  //

  public ResultSet getSuppInfo() {
    try {
      String query = "SELECT * FROM suppliers";
      this.resultSet = this.statement.executeQuery(query);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
    
  //
  //Takes result information from customers and returns what is taken.
  //

  public ResultSet getCustInfo() {
    try {
      String query = "SELECT * FROM customers";
      this.resultSet = this.statement.executeQuery(query);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
    
  //
  //Takes result information from currentstock and returns what is taken.
  //

  public ResultSet getProdStock() {
    try {
      String query = "SELECT * FROM currentstock";
      this.resultSet = this.statement.executeQuery(query);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
    
  //
  //Takes result information from products and returns what is taken.
  //

  public ResultSet getProdInfo() {
    try {
      String query = "SELECT * FROM products";
      this.resultSet = this.statement.executeQuery(query);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
    
  //
  // Returns product cost from costprice --> products and returns what is taken.
  //

  public Double getProdCost(String prodCode) {
    Double costPrice = null;
    try {
      String query = "SELECT costprice FROM products WHERE productcode='" + prodCode + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        costPrice = Double.valueOf(this.resultSet.getDouble("costprice")); 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return costPrice;
  }
      
  //
  // Returns product cost from sellprice --> products and returns what is taken.
  //

  public Double getProdSell(String prodCode) {
    Double sellPrice = null;
    try {
      String query = "SELECT sellprice FROM products WHERE productcode='" + prodCode + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        sellPrice = Double.valueOf(this.resultSet.getDouble("sellprice")); 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return sellPrice;
  }
      
  //
  // Returns product cost from suppliercode --> suppliers and returns what is taken.
  //

  public String getSuppCode(String suppName) {
    try {
      String query = "SELECT suppliercode FROM suppliers WHERE fullname='" + suppName + "'";
      this.resultSet = this.statement.executeQuery(query);
      while (this.resultSet.next())
        this.suppCode = this.resultSet.getString("suppliercode"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.suppCode;
  }
      
  //
  // Returns product cost from productcode --> products and returns what is taken.
  //

  public String getProdCode(String prodName) {
    try {
      String query = "SELECT productcode FROM products WHERE productname='" + prodName + "'";
      this.resultSet = this.statement.executeQuery(query);
      while (this.resultSet.next())
        this.suppCode = this.resultSet.getString("productcode"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.prodCode;
  }
      
  //
  // Returns product cost from customercode --> suppliers and returns what is taken.
  //

  public String getCustCode(String custName) {
    try {
      String query = "SELECT customercode FROM suppliers WHERE fullname='" + custName + "'";
      this.resultSet = this.statement.executeQuery(query);
      while (this.resultSet.next())
        this.suppCode = this.resultSet.getString("customercode"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.custCode;
  }
      
  //
  // Tries the connection with product.
  //

  public ProductDAO() {
    this.flag = false;
    try {
      this.conn = (new ConnectionFactory()).getConn();
      this.statement = this.conn.createStatement();
      this.statement2 = this.conn.createStatement();
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }

  //
  //"checkStock" looks at current stock and product code to return existing data from that table.
  //
  public boolean checkStock(String prodCode) {
    try {
      String query = "SELECT * FROM currentstock WHERE productcode='" + prodCode + "'";
      this.resultSet = this.statement.executeQuery(query);
      while (this.resultSet.next())
        this.flag = true; 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.flag;
  }

  //
  //Responds to user "product has already been added" if product already exists in database. If not, then "addFunction" is run.
  //
  public void addProductDAO(ProductDTO productDTO) {
    try {
      String query = "SELECT * FROM products WHERE productname='" + productDTO.getProdName() + "' AND costprice='" + productDTO.getCostPrice() + "' AND sellprice='" + productDTO.getSellPrice() + "' AND brand='" + productDTO.getBrand() + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Product has already been added.");
      } else {
        addFunction(productDTO);
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  //
  //This code allows the user to add a new product data.
  //
  public void addFunction(ProductDTO productDTO) {
    try {
      String query = "INSERT INTO products VALUES(null,?,?,?,?,?)";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, productDTO.getProdCode());
      this.prepStatement.setString(2, productDTO.getProdName());
      this.prepStatement.setDouble(3, productDTO.getCostPrice());
      this.prepStatement.setDouble(4, productDTO.getSellPrice());
      this.prepStatement.setString(5, productDTO.getBrand());
      String query2 = "INSERT INTO currentstock VALUES(?,?)";
      this.prepStatement2 = this.conn.prepareStatement(query2);
      this.prepStatement2.setString(1, productDTO.getProdCode());
      this.prepStatement2.setInt(2, productDTO.getQuantity());
      this.prepStatement.executeUpdate();
      this.prepStatement2.executeUpdate();
      JOptionPane.showMessageDialog(null, "Product added and ready for sale.");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }

  //
  //This code allows the user to add purchase by checking stock (via product code).
  //
  public void addPurchaseDAO(ProductDTO productDTO) {
    try {
      String query = "INSERT INTO purchaseinfo VALUES(null,?,?,?,?,?)";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, productDTO.getSuppCode());
      this.prepStatement.setString(2, productDTO.getProdCode());
      this.prepStatement.setString(3, productDTO.getDate());
      this.prepStatement.setInt(4, productDTO.getQuantity());
      this.prepStatement.setDouble(5, productDTO.getTotalCost().doubleValue());
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "Purchase log added.");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    String prodCode = productDTO.getProdCode();
    if (checkStock(prodCode)) {
      try {
        String query = "UPDATE currentstock SET quantity=quantity+? WHERE productcode=?";
        this.prepStatement = this.conn.prepareStatement(query);
        this.prepStatement.setInt(1, productDTO.getQuantity());
        this.prepStatement.setString(2, prodCode);
        this.prepStatement.executeUpdate();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } 
    } else if (!checkStock(prodCode)) {
      try {
        String query = "INSERT INTO currentstock VALUES(?,?)";
        this.prepStatement = this.conn.prepareStatement(query);
        this.prepStatement.setString(1, productDTO.getProdCode());
        this.prepStatement.setInt(2, productDTO.getQuantity());
        this.prepStatement.executeUpdate();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } 
    } 
    deleteStock();
  }

  //
  //This code allows user to edit a product's data.
  //
  public void editProdDAO(ProductDTO productDTO) {
    try {
      String query = "UPDATE products SET productname=?,costprice=?,sellprice=?,brand=? WHERE productcode=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, productDTO.getProdName());
      this.prepStatement.setDouble(2, productDTO.getCostPrice());
      this.prepStatement.setDouble(3, productDTO.getSellPrice());
      this.prepStatement.setString(4, productDTO.getBrand());
      this.prepStatement.setString(5, productDTO.getProdCode());
      String query2 = "UPDATE currentstock SET quantity=? WHERE productcode=?";
      this.prepStatement2 = this.conn.prepareStatement(query2);
      this.prepStatement2.setInt(1, productDTO.getQuantity());
      this.prepStatement2.setString(2, productDTO.getProdCode());
      this.prepStatement.executeUpdate();
      this.prepStatement2.executeUpdate();
      JOptionPane.showMessageDialog(null, "Product details updated.");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }

  //
  //This code allows user to edit pruchase stock data.
  //
  public void editPurchaseStock(String code, int quantity) {
    try {
      String query = "SELECT * FROM currentstock WHERE productcode='" + code + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next()) {
        String query2 = "UPDATE currentstock SET quantity=quantity-? WHERE productcode=?";
        this.prepStatement = this.conn.prepareStatement(query2);
        this.prepStatement.setInt(1, quantity);
        this.prepStatement.setString(2, code);
        this.prepStatement.executeUpdate();
      } 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }

  //
  //This code allows user to edit sold stock data.
  //
  public void editSoldStock(String code, int quantity) {
    try {
      String query = "SELECT * FROM currentstock WHERE productcode='" + code + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next()) {
        String query2 = "UPDATE currentstock SET quantity=quantity+? WHERE productcode=?";
        this.prepStatement = this.conn.prepareStatement(query2);
        this.prepStatement.setInt(1, quantity);
        this.prepStatement.setString(2, code);
        this.prepStatement.executeUpdate();
      } 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }

  //
  //This code allows user to delete a stock data.
  //
  public void deleteStock() {
    try {
      String query = "DELETE FROM currentstock WHERE productcode NOT IN(SELECT productcode FROM purchaseinfo)";
      String query2 = "DELETE FROM salesinfo WHERE productcode NOT IN(SELECT productcode FROM products)";
      this.statement.executeUpdate(query);
      this.statement.executeUpdate(query2);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }

  //
  //This code allows user to delete a product's data.
  //
  public void deleteProductDAO(String code) {
    try {
      String query = "DELETE FROM products WHERE productcode=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, code);
      String query2 = "DELETE FROM currentstock WHERE productcode=?";
      this.prepStatement2 = this.conn.prepareStatement(query2);
      this.prepStatement2.setString(1, code);
      this.prepStatement.executeUpdate();
      this.prepStatement2.executeUpdate();
      JOptionPane.showMessageDialog(null, "Product has been removed.");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    deleteStock();
  }

  //
  //This code allows user to delete a purchase's data.
  //
  public void deletePurchaseDAO(int ID) {
    try {
      String query = "DELETE FROM purchaseinfo WHERE purchaseID=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setInt(1, ID);
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "Transaction has been removed.");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    deleteStock();
  }

  //
  //This code allows user to delete a sale's data.
  //
  public void deleteSaleDAO(int ID) {
    try {
      String query = "DELETE FROM salesinfo WHERE salesID=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setInt(1, ID);
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "Transaction has been removed.");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    deleteStock();
  }

  //
  //This code allows user to sell product based on stock and quantity.
  //
  public void sellProductDAO(ProductDTO productDTO, String username) {
    int quantity = 0;
    String prodCode = null;
    try {
      String query = "SELECT * FROM currentstock WHERE productcode='" + productDTO.getProdCode() + "'";
      this.resultSet = this.statement.executeQuery(query);
      while (this.resultSet.next()) {
        prodCode = this.resultSet.getString("productcode");
        quantity = this.resultSet.getInt("quantity");
      } 
      if (productDTO.getQuantity() > quantity) {
        JOptionPane.showMessageDialog(null, "Insufficient stock for this product.");
      } else if (productDTO.getQuantity() <= 0) {
        JOptionPane.showMessageDialog(null, "Please enter a valid quantity");
      } else {
        String stockQuery = "UPDATE currentstock SET quantity=quantity-'" + productDTO.getQuantity() + "' WHERE productcode='" + productDTO.getProdCode() + "'";
        String salesQuery = "INSERT INTO salesinfo(date,productcode,customercode,quantity,revenue,soldby)VALUES('" + productDTO.getDate() + "','" + productDTO.getProdCode() + "','" + productDTO.getCustCode() + "','" + productDTO.getQuantity() + "','" + productDTO.getTotalRevenue() + "','" + username + "')";
        this.statement.executeUpdate(stockQuery);
        this.statement.executeUpdate(salesQuery);
        JOptionPane.showMessageDialog(null, "Product sold.");
      } 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
  }

  //
  //This code returns product data from database.
  //
  public ResultSet getQueryResult() {
    try {
      String query = "SELECT productcode,productname,costprice,sellprice,brand FROM products ORDER BY pid";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns purchase info of a product's data.
  //
  public ResultSet getPurchaseInfo() {
    try {
      String query = "SELECT PurchaseID,purchaseinfo.ProductCode,ProductName,Quantity,Totalcost FROM purchaseinfo INNER JOIN products ON products.productcode=purchaseinfo.productcode ORDER BY purchaseid;";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns current stock info based on product data.
  //
  public ResultSet getCurrentStockInfo() {
    try {
      String query = "SELECT currentstock.ProductCode,products.ProductName,\ncurrentstock.Quantity,products.CostPrice,products.SellPrice\nFROM currentstock INNER JOIN products\nON currentstock.productcode=products.productcode;\n";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns sales info based on product's data and quantatiy, revenue, and user.
  //
  public ResultSet getSalesInfo() {
    try {
      String query = "SELECT salesid,salesinfo.productcode,productname,\nsalesinfo.quantity,revenue,users.name AS Sold_by\nFROM salesinfo INNER JOIN products\nON salesinfo.productcode=products.productcode\nINNER JOIN users\nON salesinfo.soldby=users.username;\n";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns a product search.
  //
  public ResultSet getProductSearch(String text) {
    try {
      String query = "SELECT productcode,productname,costprice,sellprice,brand FROM products WHERE productcode LIKE '%" + text + "%' OR productname LIKE '%" + text + "%' OR brand LIKE '%" + text + "%'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns product from product code using product code, name, costprice, sellprice, and brand.
  //
  public ResultSet getProdFromCode(String text) {
    try {
      String query = "SELECT productcode,productname,costprice,sellprice,brand FROM products WHERE productcode='" + text + "' LIMIT 1";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns a sales search.
  //
  public ResultSet getSalesSearch(String text) {
    try {
      String query = "SELECT salesid,salesinfo.productcode,productname,\n                    salesinfo.quantity,revenue,users.name AS Sold_by\n                    FROM salesinfo INNER JOIN products\n                    ON salesinfo.productcode=products.productcode\n                    INNER JOIN users\n                    ON salesinfo.soldby=users.username\n                    INNER JOIN customers\n                    ON customers.customercode=salesinfo.customercode\nWHERE salesinfo.productcode LIKE '%" + text + "%' OR productname LIKE '%" + text + "%' OR users.name LIKE '%" + text + "%' OR customers.fullname LIKE '%" + text + "%' ORDER BY salesid;";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns a purchase search.
  //
  public ResultSet getPurchaseSearch(String text) {
    try {
      String query = "SELECT PurchaseID,purchaseinfo.productcode,products.productname,quantity,totalcost FROM purchaseinfo INNER JOIN products ON purchaseinfo.productcode=products.productcode INNER JOIN suppliers ON purchaseinfo.suppliercode=suppliers.suppliercodeWHERE PurchaseID LIKE '%" + text + "%' OR productcode LIKE '%" + text + "%' OR productname LIKE '%" + text + "%' OR suppliers.fullname LIKE '%" + text + "%' OR purchaseinfo.suppliercode LIKE '%" + text + "%' OR date LIKE '%" + text + "%' ORDER BY purchaseid";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns a product's name from product (-> product code)
  //
  public ResultSet getProdName(String code) {
    try {
      String query = "SELECT productname FROM products WHERE productcode='" + code + "'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return this.resultSet;
  }

  //
  //This code returns supplier name.
  //
  public String getSuppName(int ID) {
    String name = null;
    try {
      String query = "SELECT fullname FROM suppliers INNER JOIN purchaseinfo ON suppliers.suppliercode=purchaseinfo.suppliercode WHERE purchaseid='" + ID + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        name = this.resultSet.getString("fullname"); 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return name;
  }

  //
  //This code returns a customer's name.
  //
  public String getCustName(int ID) {
    String name = null;
    try {
      String query = "SELECT fullname FROM customers INNER JOIN salesinfo ON customers.customercode=salesinfo.customercode WHERE salesid='" + ID + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        name = this.resultSet.getString("fullname"); 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return name;
  }

  //
  //This code returns a purchase date.
  //
  public String getPurchaseDate(int ID) {
    String date = null;
    try {
      String query = "SELECT date FROM purchaseinfo WHERE purchaseid='" + ID + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        date = this.resultSet.getString("date"); 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return date;
  }

  //
  //This code returns a sale date.
  //
  public String getSaleDate(int ID) {
    String date = null;
    try {
      String query = "SELECT date FROM salesinfo WHERE salesid='" + ID + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next())
        date = this.resultSet.getString("date"); 
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } 
    return date;
  }

  //
  //This code creates the table using columns.
  //
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
