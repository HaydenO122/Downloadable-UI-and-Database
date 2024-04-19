package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class HomePage extends JPanel {
  private JLabel jLabel1;
  
  private JLabel welcomeLabel;
  
  public HomePage(String username) {
    initComponents();
    UserDTO userDTO = new UserDTO();
    (new UserDAO()).getFullName(userDTO, username);
    this.welcomeLabel.setText("Welcome,  " + userDTO.getFullName() + ".");
  }
  
  private void initComponents() {
    this.welcomeLabel = new JLabel();
    this.jLabel1 = new JLabel();
    this.welcomeLabel.setFont(new Font("Impact", 0, 36));
    this.welcomeLabel.setText("Welcome");
    this.jLabel1.setFont(new Font("Impact", 0, 18));
    this.jLabel1.setHorizontalAlignment(0);
    this.jLabel1.setText("<html>Manage  your  inventory,  transactions  and  personnel,  all  in  one place.<br><br>Click  on  the  Menu  button  to  start.<html>");
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(this.welcomeLabel, -2, 355, -2))
            .addGroup(layout.createSequentialGroup()
              .addGap(54, 54, 54)
              .addComponent(this.jLabel1, -1, 355, 32767)))
          .addContainerGap(84, 32767)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(12, 12, 12)
          .addComponent(this.welcomeLabel, -2, 48, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jLabel1, -2, 133, -2)
          .addContainerGap(174, 32767)));
  }
}
