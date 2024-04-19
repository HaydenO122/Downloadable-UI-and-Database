package com.inventory.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class null extends MouseAdapter {
  public void mouseClicked(MouseEvent evt) {
    UsersPage.this.userTableMouseClicked(evt);
  }
}
