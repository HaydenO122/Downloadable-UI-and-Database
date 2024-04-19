package com.inventory.UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class null extends KeyAdapter {
  public void keyReleased(KeyEvent evt) {
    ProductPage.this.searchTextKeyReleased(evt);
  }
}
