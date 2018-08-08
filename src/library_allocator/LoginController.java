/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_allocator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginController {
    private String userName = null;
    private String password = null;
    
    private Connection con = null;
    private Statement statement = null;
    
    public void connectToDB() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/library_manager";
        String user = "root";
        String password = "";
            

        try{
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }

    public LoginController(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public boolean checkLogin() throws SQLException{
    //Login in as admin
    PreparedStatement prep = con.prepareStatement("SELECT * FROM `admin` WHERE username =  ? AND password = ? LIMIT 1");
    prep.setString(1, userName); 
    prep.setString(2, password); 
    ResultSet rs = prep.executeQuery();
    if (rs.next()){
        return rs.getInt(1) >= 1;
    }

      //  JOptionPane.showMessageDialog(null, rs.getInt(1), "Successful", JOptionPane.PLAIN_MESSAGE);
    return false;
    }
    
}
