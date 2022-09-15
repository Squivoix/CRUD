/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Utils.Utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Henrique
 */
public class Borrows extends javax.swing.JFrame {
    
    public Borrows() {
        initComponents();
        
        if(Utils.profile != 5) {
            UsersMenuItem.setVisible(false);
            
            BorrowsTable.getColumnModel().getColumn(0).setMinWidth(0);
            BorrowsTable.getColumnModel().getColumn(0).setMaxWidth(0);
            BorrowsTable.getColumnModel().getColumn(0).setWidth(0);
            
            BorrowsTable.getColumnModel().getColumn(1).setMinWidth(0);
            BorrowsTable.getColumnModel().getColumn(1).setMaxWidth(0);
            BorrowsTable.getColumnModel().getColumn(1).setWidth(0);
            
            BorrowsTable.getColumnModel().getColumn(3).setMinWidth(0);
            BorrowsTable.getColumnModel().getColumn(3).setMaxWidth(0);
            BorrowsTable.getColumnModel().getColumn(3).setWidth(0);
        }
        
        ResultSet result = null;
        
        if(Utils.profile == 5) result = Utils.SelectAllRegistry("borrows");
        else                   result = Utils.SelectUserBorrows();
        
        try {
            while(result.next()) {
                int id = result.getInt("id");
                int id_book = result.getInt("id_book");
                int id_user = result.getInt("id_user");
                String date_borrow = result.getDate("date_borrow").toString();
                String date_devolution = result.getDate("date_devolution").toString();
                String date_effective = result.getDate("date_effective") == null ? "" : result.getDate("date_effective").toString();

                String book_name = "";
                String user_name = "";
                
                ResultSet result2 = Utils.SelectSingleRegistry(id_book, "books");
                ResultSet result3 = Utils.SelectSingleRegistry(id_user, "users");
                
                while(result2.next()) {
                    book_name = result2.getString("title");
                }

                while(result3.next()) {
                    user_name = result3.getString("name");
                }

                Object[] data = {id, id_book, book_name, id_user, user_name, date_borrow, date_devolution, date_effective};
                
                ((DefaultTableModel)BorrowsTable.getModel()).addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Borrows.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHolder = new javax.swing.JPanel();
        TableScrollPanel = new javax.swing.JScrollPane();
        BorrowsTable = new javax.swing.JTable();
        OperationsToolBar = new javax.swing.JToolBar();
        UnborrowButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        WindowMenu = new javax.swing.JMenu();
        BooksMenuItem = new javax.swing.JMenuItem();
        UsersMenuItem = new javax.swing.JMenuItem();
        BorrowsMenuItem = new javax.swing.JMenuItem();
        UserMenu = new javax.swing.JMenu();
        EditMenuItem = new javax.swing.JMenuItem();
        LogOutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BorrowsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BorrowsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Id", "Book Name", "User Id", "User Name", "Date Borrow", "Date Devolution", "Date Effective"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BorrowsTable.setIntercellSpacing(new java.awt.Dimension(0, 5));
        BorrowsTable.setRowHeight(30);
        BorrowsTable.getTableHeader().setReorderingAllowed(false);
        TableScrollPanel.setViewportView(BorrowsTable);

        OperationsToolBar.setFloatable(false);
        OperationsToolBar.setFocusable(false);

        UnborrowButton.setText("Unborrow");
        UnborrowButton.setFocusable(false);
        UnborrowButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        UnborrowButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        UnborrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnborrowButtonActionPerformed(evt);
            }
        });
        OperationsToolBar.add(UnborrowButton);

        javax.swing.GroupLayout PanelHolderLayout = new javax.swing.GroupLayout(PanelHolder);
        PanelHolder.setLayout(PanelHolderLayout);
        PanelHolderLayout.setHorizontalGroup(
            PanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                    .addComponent(OperationsToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelHolderLayout.setVerticalGroup(
            PanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHolderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OperationsToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );

        WindowMenu.setText("Window");

        BooksMenuItem.setText("Books");
        BooksMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BooksMenuItemActionPerformed(evt);
            }
        });
        WindowMenu.add(BooksMenuItem);

        UsersMenuItem.setText("Users");
        UsersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersMenuItemActionPerformed(evt);
            }
        });
        WindowMenu.add(UsersMenuItem);

        BorrowsMenuItem.setText("Borrows");
        WindowMenu.add(BorrowsMenuItem);

        MenuBar.add(WindowMenu);

        UserMenu.setText("User");

        EditMenuItem.setText("Edit");
        EditMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMenuItemActionPerformed(evt);
            }
        });
        UserMenu.add(EditMenuItem);

        LogOutMenuItem.setText("Log out");
        LogOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutMenuItemActionPerformed(evt);
            }
        });
        UserMenu.add(LogOutMenuItem);

        MenuBar.add(UserMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuItemActionPerformed
        Utils.OpenNewWindow(new Login(), this);
    }//GEN-LAST:event_LogOutMenuItemActionPerformed

    private void UsersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersMenuItemActionPerformed
        Utils.OpenNewWindow(new Users(), this);
    }//GEN-LAST:event_UsersMenuItemActionPerformed

    private void UnborrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnborrowButtonActionPerformed
        int row = BorrowsTable.getSelectedRow();
        int id = Integer.parseInt(BorrowsTable.getValueAt(row, 0).toString());
        int book_id = Integer.parseInt(BorrowsTable.getValueAt(row, 1).toString());
        
        if(Utils.VerifyBorrow(id)) {
            JOptionPane.showMessageDialog(null, "Book has already been unborrowed!", "Book is unborrowed", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
                
        if(Utils.UnBorrowBook(id, book_id)) {
            JOptionPane.showMessageDialog(null, "Book successfully unborrowed!", "Book unborrowed", JOptionPane.INFORMATION_MESSAGE);

            Utils.OpenNewWindow(new Borrows(), this);
        }
    }//GEN-LAST:event_UnborrowButtonActionPerformed

    private void BooksMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BooksMenuItemActionPerformed
        Utils.OpenNewWindow(new Books(), this);
    }//GEN-LAST:event_BooksMenuItemActionPerformed

    private void EditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMenuItemActionPerformed
        Utils.OpenNewWindow(new ModifyUser(), this);
    }//GEN-LAST:event_EditMenuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BooksMenuItem;
    private javax.swing.JMenuItem BorrowsMenuItem;
    private javax.swing.JTable BorrowsTable;
    private javax.swing.JMenuItem EditMenuItem;
    private javax.swing.JMenuItem LogOutMenuItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JToolBar OperationsToolBar;
    private javax.swing.JPanel PanelHolder;
    private javax.swing.JScrollPane TableScrollPanel;
    private javax.swing.JButton UnborrowButton;
    private javax.swing.JMenu UserMenu;
    private javax.swing.JMenuItem UsersMenuItem;
    private javax.swing.JMenu WindowMenu;
    // End of variables declaration//GEN-END:variables
}
