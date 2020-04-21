/***************************************
*Program Name: Barn Burger Ordering System
*Programmer's Name: Henry Bonilla
* Program Description: This is a Graphic
* User Interface Program that has burger
* options for users to choose and quantity
* option for multiple same orders. The user
* also has the option to add new orders to
* current current or to start over.
****************************************/


package barnburger;

import javax.swing.JOptionPane;

public class Barn_Frame extends javax.swing.JFrame {

    //sets BurgerOrder object
    private BurgerOrder anOrder = null;
    
    //clear and defaults all items
    private void clearItems()
    {
        txtItemPrice.setText("0");
        txtQuantity.setText("1");
        
        radSingle.setSelected(true);
        
        chkCheese.setSelected(false);
        chkBacon.setSelected(false);
        chkMeal.setSelected(false);
        
        anOrder.clearOrder();
    }
    
    //create complete new order for new customer
    private void newOrder()
    {
        anOrder = new BurgerOrder();
        anOrder.clearAllOrders();
        clearItems();
        txtAreaOrder.setText("");
        txtTotal.setText("");
    }
    
    //sets total cost of current items
    private void setSubTotal()
    {
        txtItemPrice.setText(anOrder.getTotalCost());
    }
    
    /*checks for quantity validity
    and then submits order for display
    in main text area
    */
    private void submitOrder()
    {
        try
        {
            anOrder.setQuantity(Integer.parseInt(txtQuantity.getText()));
            
            StringBuilder str = new StringBuilder();
        
            str.append(anOrder.getOrderInformation());
            
            txtAreaOrder.append(str.toString());
            txtTotal.setText(anOrder.getFinalCost());
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Quantity must be numeric");
            txtQuantity.setText("");
        }
        

    }
    
    //sets size of current order accordingly of radio button
    private void setSize(BurgerOrder.BurgerSize size)
    {
        anOrder.setBurgerSize(size);
        setSubTotal();
    }
    
    //sets cheese
    private void setCheese()
    {
        if(chkCheese.isSelected())
        {
            anOrder.setCheese(true);
        }
        else
        {
            anOrder.setCheese(false);
        }
        setSubTotal();
    }
    
    //sets bacon
    private void setBacon()
    {
        if(chkBacon.isSelected())
        {
            anOrder.setBacon(true);
        }
        else
        {
            anOrder.setBacon(false);
        }
        setSubTotal();
    }
    
    //sets meal
    private void setMeal()
    {
        if(chkMeal.isSelected())
        {
            anOrder.setMeal(true);
        }
        else
        {
            anOrder.setMeal(false);
        }
        setSubTotal();
    }
    
    //asks user to close program
    private void terminateApplication()
    {
        int response = JOptionPane.NO_OPTION;
        String prompt = "Do you want to quit the Barn Burger?";
        String title = "Quit Barn Burger";
        response = JOptionPane.showConfirmDialog(null, prompt, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }    
    
    public Barn_Frame() {
        initComponents();
        super.setLocationRelativeTo(null);
        newOrder();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        radSingle = new javax.swing.JRadioButton();
        radDouble = new javax.swing.JRadioButton();
        chkCheese = new javax.swing.JCheckBox();
        chkBacon = new javax.swing.JCheckBox();
        chkMeal = new javax.swing.JCheckBox();
        labelYourOrder = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaOrder = new javax.swing.JTextArea();
        labelPriceItem = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JTextField();
        labelQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuExit = new javax.swing.JMenuItem();
        mnuOrder = new javax.swing.JMenu();
        mnuAddOrder = new javax.swing.JMenuItem();
        mnuClear = new javax.swing.JMenuItem();
        mnuNewOrder = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Barn Burger");

        buttonGroup1.add(radSingle);
        radSingle.setText("Single Burger");
        radSingle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radSingleItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radDouble);
        radDouble.setText("Double Burger");
        radDouble.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radDoubleItemStateChanged(evt);
            }
        });

        chkCheese.setText("Add cheese");
        chkCheese.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkCheeseItemStateChanged(evt);
            }
        });

        chkBacon.setText("Add bacon");
        chkBacon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBaconItemStateChanged(evt);
            }
        });

        chkMeal.setText("Make it a meal");
        chkMeal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMealItemStateChanged(evt);
            }
        });

        labelYourOrder.setText("YOUR ORDER");

        txtAreaOrder.setEditable(false);
        txtAreaOrder.setColumns(20);
        txtAreaOrder.setRows(5);
        jScrollPane1.setViewportView(txtAreaOrder);

        labelPriceItem.setText("Item Price");

        txtItemPrice.setEditable(false);

        labelQuantity.setText("Quantity");

        labelTotal.setText("Order Total");

        txtTotal.setEditable(false);

        mnuFile.setText("File");

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        jMenuBar1.add(mnuFile);

        mnuOrder.setText("Order");

        mnuAddOrder.setText("Add to Order");
        mnuAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddOrderActionPerformed(evt);
            }
        });
        mnuOrder.add(mnuAddOrder);

        mnuClear.setText("Clear for next item");
        mnuClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClearActionPerformed(evt);
            }
        });
        mnuOrder.add(mnuClear);

        mnuNewOrder.setText("New Order");
        mnuNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewOrderActionPerformed(evt);
            }
        });
        mnuOrder.add(mnuNewOrder);

        jMenuBar1.add(mnuOrder);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPriceItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkMeal)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkBacon)
                                    .addComponent(chkCheese)
                                    .addComponent(radDouble)
                                    .addComponent(radSingle))
                                .addGap(70, 70, 70)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelYourOrder)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelYourOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radSingle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radDouble)
                        .addGap(18, 18, 18)
                        .addComponent(chkCheese)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkBacon))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMeal)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPriceItem)
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        terminateApplication();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void radSingleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radSingleItemStateChanged
        if(radSingle.isSelected())
        {
            setSize(BurgerOrder.BurgerSize.Single);
        }
    }//GEN-LAST:event_radSingleItemStateChanged

    private void radDoubleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radDoubleItemStateChanged
        if(radDouble.isSelected())
        {
            setSize(BurgerOrder.BurgerSize.Double);
        }
    }//GEN-LAST:event_radDoubleItemStateChanged

    private void chkCheeseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkCheeseItemStateChanged
        setCheese();
    }//GEN-LAST:event_chkCheeseItemStateChanged

    private void chkBaconItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBaconItemStateChanged
        setBacon();
    }//GEN-LAST:event_chkBaconItemStateChanged

    private void chkMealItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMealItemStateChanged
        setMeal();
    }//GEN-LAST:event_chkMealItemStateChanged

    private void mnuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClearActionPerformed
        clearItems();
    }//GEN-LAST:event_mnuClearActionPerformed

    private void mnuNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewOrderActionPerformed
        newOrder();
    }//GEN-LAST:event_mnuNewOrderActionPerformed

    private void mnuAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddOrderActionPerformed
        submitOrder();
    }//GEN-LAST:event_mnuAddOrderActionPerformed

    
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Barn_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barn_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barn_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barn_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barn_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkBacon;
    private javax.swing.JCheckBox chkCheese;
    private javax.swing.JCheckBox chkMeal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPriceItem;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelYourOrder;
    private javax.swing.JMenuItem mnuAddOrder;
    private javax.swing.JMenuItem mnuClear;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuNewOrder;
    private javax.swing.JMenu mnuOrder;
    private javax.swing.JRadioButton radDouble;
    private javax.swing.JRadioButton radSingle;
    private javax.swing.JTextArea txtAreaOrder;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
