package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.SoftBevelBorder;

public class Dashboard extends JFrame {
  CardLayout layout;
  
  String userSelect;
  
  String username;
  
  String fullName;
  
  UserDTO userDTO;
  
  LocalDateTime outTime;
  
  private JButton custButton;
  
  private JPanel displayPanel;
  
  private JButton homeButton;
  
  private JMenu jMenu1;
  
  private JMenu jMenu2;
  
  private JMenuBar jMenuBar1;
  
  private JButton logoutButton;
  
  private JButton logsButton;
  
  private JPanel mainPanel;
  
  private JButton menuButton;
  
  private JPanel menuPanel;
  
  private JLabel nameLabel;
  
  private JPanel navPanel;
  
  private JButton prodButton;
  
  private JButton purchaseButton;
  
  private JButton salesButton;
  
  private JButton stockButton;
  
  private JButton suppButton;
  
  private JPanel userPanel;
  
  private JButton usersButton;
  
  public Dashboard(final String username, String userType, final UserDTO userDTO) {
    initComponents();
    this.navPanel.setVisible(false);
    this.menuPanel.setVisible(true);
    this.layout = new CardLayout();
    this.userSelect = userType;
    this.username = username;
    this.userDTO = userDTO;
    if ("EMPLOYEE".equalsIgnoreCase(userType))
      notForEmployee(); 
    currentUserSession();
    this.displayPanel.setLayout(this.layout);
    this.displayPanel.add("Home", new HomePage(username));
    this.displayPanel.add("Users", new UsersPage());
    this.displayPanel.add("Customers", new CustomerPage());
    this.displayPanel.add("Products", new ProductPage(username, this));
    this.displayPanel.add("Suppliers", new SupplierPage());
    this.displayPanel.add("Current Stock", new CurrentStockPage(username));
    this.displayPanel.add("Sales", new SalesPage(username, this));
    this.displayPanel.add("Purchase", new PurchasePage(this));
    this.displayPanel.add("Logs", new UserLogsPage());
    addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            Dashboard.this.outTime = LocalDateTime.now();
            userDTO.setOutTime(String.valueOf(Dashboard.this.outTime));
            userDTO.setUsername(username);
            (new UserDAO()).addUserLogin(userDTO);
            super.windowClosing(e);
          }
        });
    setTitle("Inventory Manager");
    setVisible(true);
  }
  
  public void addHomePage() {
    this.layout.show(this.displayPanel, "Home");
  }
  
  public void addUsersPage() {
    this.layout.show(this.displayPanel, "Users");
  }
  
  public void addCustPage() {
    this.layout.show(this.displayPanel, "Customers");
  }
  
  public void addProdPage() {
    this.layout.show(this.displayPanel, "Products");
  }
  
  public void addSuppPage() {
    this.layout.show(this.displayPanel, "Suppliers");
  }
  
  public void addStockPage() {
    this.layout.show(this.displayPanel, "Current Stock");
  }
  
  public void addSalesPage() {
    this.layout.show(this.displayPanel, "Sales");
  }
  
  public void addPurchasePage() {
    this.layout.show(this.displayPanel, "Purchase");
  }
  
  public void addLogsPage() {
    this.layout.show(this.displayPanel, "Logs");
  }
  
  private void initComponents() {
    this.mainPanel = new JPanel();
    this.menuPanel = new JPanel();
    this.menuButton = new JButton();
    this.navPanel = new JPanel();
    this.homeButton = new JButton();
    this.prodButton = new JButton();
    this.stockButton = new JButton();
    this.custButton = new JButton();
    this.suppButton = new JButton();
    this.salesButton = new JButton();
    this.usersButton = new JButton();
    this.purchaseButton = new JButton();
    this.logsButton = new JButton();
    this.displayPanel = new JPanel();
    this.userPanel = new JPanel();
    this.nameLabel = new JLabel();
    this.logoutButton = new JButton();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jMenu2 = new JMenu();
    setDefaultCloseOperation(3);
    setTitle("Inventory Manager");
    setBounds(new Rectangle(400, 100, 0, 0));
    this.menuPanel.setPreferredSize(new Dimension(120, 26));
    this.menuButton.setFont(new Font("Segoe UI", 1, 14));
    this.menuButton.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/menu_icon_150667.png")));
    this.menuButton.setText("MENU");
    this.menuButton.setCursor(new Cursor(12));
    this.menuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.menuButtonActionPerformed(evt);
          }
        });
    GroupLayout menuPanelLayout = new GroupLayout(this.menuPanel);
    this.menuPanel.setLayout(menuPanelLayout);
    menuPanelLayout.setHorizontalGroup(menuPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.menuButton, -1, -1, 32767));
    menuPanelLayout.setVerticalGroup(menuPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(menuPanelLayout.createSequentialGroup()
          .addComponent(this.menuButton, -2, 52, -2)
          .addContainerGap()));
    this.navPanel.setBorder(new SoftBevelBorder(0));
    this.homeButton.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/homepages_home_house_icon_150665.png")));
    this.homeButton.setCursor(new Cursor(12));
    this.homeButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.homeButtonActionPerformed(evt);
          }
        });
    this.prodButton.setText("Products");
    this.prodButton.setCursor(new Cursor(12));
    this.prodButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.prodButtonActionPerformed(evt);
          }
        });
    this.stockButton.setText("Current Stock");
    this.stockButton.setCursor(new Cursor(12));
    this.stockButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.stockButtonActionPerformed(evt);
          }
        });
    this.custButton.setText("Customers");
    this.custButton.setCursor(new Cursor(12));
    this.custButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.custButtonActionPerformed(evt);
          }
        });
    this.suppButton.setText("Suppliers");
    this.suppButton.setCursor(new Cursor(12));
    this.suppButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.suppButtonActionPerformed(evt);
          }
        });
    this.salesButton.setText("Sales");
    this.salesButton.setCursor(new Cursor(12));
    this.salesButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.salesButtonActionPerformed(evt);
          }
        });
    this.usersButton.setText("Users");
    this.usersButton.setCursor(new Cursor(12));
    this.usersButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.usersButtonActionPerformed(evt);
          }
        });
    this.purchaseButton.setText("Purchase");
    this.purchaseButton.setCursor(new Cursor(12));
    this.purchaseButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.purchaseButtonActionPerformed(evt);
          }
        });
    this.logsButton.setText("User Logs");
    this.logsButton.setCursor(new Cursor(12));
    this.logsButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.logsButtonActionPerformed(evt);
          }
        });
    GroupLayout navPanelLayout = new GroupLayout(this.navPanel);
    this.navPanel.setLayout(navPanelLayout);
    navPanelLayout.setHorizontalGroup(navPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(navPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(navPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.homeButton, -1, -1, 32767)
            .addComponent(this.prodButton, -1, -1, 32767)
            .addComponent(this.stockButton, -1, 107, 32767)
            .addComponent(this.custButton, -1, -1, 32767)
            .addComponent(this.suppButton, -1, -1, 32767)
            .addComponent(this.salesButton, -1, -1, 32767)
            .addComponent(this.usersButton, -1, -1, 32767)
            .addComponent(this.purchaseButton, -1, -1, 32767)
            .addComponent(this.logsButton, -1, -1, 32767))
          .addContainerGap()));
    navPanelLayout.setVerticalGroup(navPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(navPanelLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.homeButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.prodButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.stockButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.custButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.suppButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.salesButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.purchaseButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.usersButton, -2, 35, -2)
          .addGap(18, 18, 18)
          .addComponent(this.logsButton, -2, 35, -2)
          .addContainerGap(24, 32767)));
    this.displayPanel.setLayout(new CardLayout());
    this.nameLabel.setFont(new Font("Segoe UI Black", 0, 12));
    this.nameLabel.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/user_icon_150670.png")));
    this.nameLabel.setText("User: ");
    this.nameLabel.setVerticalAlignment(1);
    this.logoutButton.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/log-out_icon-icons.com_50106.png")));
    this.logoutButton.setText("Sign out");
    this.logoutButton.setCursor(new Cursor(12));
    this.logoutButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Dashboard.this.logoutButtonActionPerformed(evt);
          }
        });
    GroupLayout userPanelLayout = new GroupLayout(this.userPanel);
    this.userPanel.setLayout(userPanelLayout);
    userPanelLayout.setHorizontalGroup(userPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(userPanelLayout.createSequentialGroup()
          .addContainerGap(401, 32767)
          .addComponent(this.nameLabel, -2, 262, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.logoutButton)));
    userPanelLayout.setVerticalGroup(userPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(userPanelLayout.createSequentialGroup()
          .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
            .addGroup(GroupLayout.Alignment.LEADING, userPanelLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(this.nameLabel, -1, -1, 32767))
            .addComponent(this.logoutButton, -2, 36, -2))
          .addGap(0, 0, 32767)));
    GroupLayout mainPanelLayout = new GroupLayout(this.mainPanel);
    this.mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(mainPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
          .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.navPanel, -1, -1, 32767)
            .addComponent(this.menuPanel, -1, 125, 32767))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.displayPanel, -1, -1, 32767)
            .addComponent(this.userPanel, -1, -1, 32767))));
    mainPanelLayout.setVerticalGroup(mainPanelLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
          .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.userPanel, -1, -1, -2)
            .addComponent(this.menuPanel, -2, 50, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.displayPanel, -1, -1, 32767)
            .addComponent(this.navPanel, -1, -1, 32767))
          .addContainerGap(-1, 32767)));
    this.jMenu1.setText("File");
    this.jMenuBar1.add(this.jMenu1);
    this.jMenu2.setText("Edit");
    this.jMenuBar1.add(this.jMenu2);
    setJMenuBar(this.jMenuBar1);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.mainPanel, -1, -1, 32767));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.mainPanel, -1, -1, 32767));
    pack();
  }
  
  private void logoutButtonActionPerformed(ActionEvent evt) {
    int opt = JOptionPane.showConfirmDialog(null, "<html>Are you sure you want to logout?<br>You will have to login again.<html>", "Confirmation", 0);
    if (opt == 0) {
      this.outTime = LocalDateTime.now();
      this.userDTO.setOutTime(String.valueOf(this.outTime));
      this.userDTO.setUsername(this.username);
      (new UserDAO()).addUserLogin(this.userDTO);
      dispose();
      LoginPage logPage = new LoginPage();
      logPage.setVisible(true);
    } 
  }
  
  private void usersButtonActionPerformed(ActionEvent evt) {
    addUsersPage();
  }
  
  private void salesButtonActionPerformed(ActionEvent evt) {
    addSalesPage();
  }
  
  private void suppButtonActionPerformed(ActionEvent evt) {
    addSuppPage();
  }
  
  private void custButtonActionPerformed(ActionEvent evt) {
    addCustPage();
  }
  
  private void stockButtonActionPerformed(ActionEvent evt) {
    addStockPage();
  }
  
  private void prodButtonActionPerformed(ActionEvent evt) {
    addProdPage();
  }
  
  private void homeButtonActionPerformed(ActionEvent evt) {
    addHomePage();
  }
  
  private void menuButtonActionPerformed(ActionEvent evt) {
    this.navPanel.setVisible(!this.navPanel.isVisible());
  }
  
  private void purchaseButtonActionPerformed(ActionEvent evt) {
    addPurchasePage();
  }
  
  private void logsButtonActionPerformed(ActionEvent evt) {
    addLogsPage();
  }
  
  public void currentUserSession() {
    UserDTO userDTO = new UserDTO();
    (new UserDAO()).getFullName(userDTO, this.username);
    this.nameLabel.setText("User: " + userDTO.getFullName() + " (" + this.userSelect + ")");
  }
  
  public void notForEmployee() {
    this.navPanel.remove(this.usersButton);
    this.navPanel.remove(this.logsButton);
  }
}
