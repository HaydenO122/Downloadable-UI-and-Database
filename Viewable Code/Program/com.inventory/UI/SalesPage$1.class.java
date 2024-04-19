package com.inventory.UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//
// This adds event "keyReleased" KeyEvent to know when key is released on the sales page.
//
class null extends KeyAdapter {
  public void keyReleased(KeyEvent evt) {
    SalesPage.this.custCodeTextKeyReleased(evt);
  }
}
