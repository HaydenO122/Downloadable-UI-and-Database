package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

class null extends WindowAdapter {
  public void windowClosing(WindowEvent e) {
    Dashboard.this.outTime = LocalDateTime.now();
    userDTO.setOutTime(String.valueOf(Dashboard.this.outTime));
    userDTO.setUsername(username);
    (new UserDAO()).addUserLogin(userDTO);
    super.windowClosing(e);
  }
}
