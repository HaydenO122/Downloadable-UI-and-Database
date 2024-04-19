package com.inventory.UI;

import javax.swing.table.DefaultTableModel;

class null extends DefaultTableModel {
  boolean[] canEdit;
  
  null(Object[][] arg0, Object[] arg1) {
    super(arg0, arg1);
    this.canEdit = new boolean[] { false, false, false, false };
  }
  
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return this.canEdit[columnIndex];
  }
}
