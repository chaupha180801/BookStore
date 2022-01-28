/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.database.Database;
import bookstore.ui.Main;
import bookstore.ui.Entry;
import bookstore.database.tables.Account;
import bookstore.ui.subpanel.*;

import javax.swing.JOptionPane;

public class App {
    static public Account account;
    
    public static void setAccount(Account account){
        App.account = account;
    }
    
    public static Account getAccount(){
        return App.account;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Database.initialize("orcl123", Account.ADMIN_USERNAME, Account.ADMIN_PASSWORD);
        Database.connect();

        if (Database.isConnected() == false){
            JOptionPane.showMessageDialog(null, "Can not connect to database.");
            System.exit(1);
        }
        Entry entry = new Entry();
        entry.show();
        //Main exampleForm = new Main();
        //exampleForm.setVisible(true);
    }
}
