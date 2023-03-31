/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quizapp;

/**
 *
 * @author manohar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Login {
   
    
    public void updatingProfile(){
         Connect c=new Connect();  
         Connection cc=c.connectivity();
        Scanner sc=new Scanner(System.in); 
        System.out.println("Enter the username you want to change");
     
        String oldUsername = sc.next(); // the old username that the user wants to change
        System.out.println("Enter your current  password");
        String oldPassword = sc.next(); // the old username that the user wants to change
        System.out.println("Enter new username");
        String newUsername = sc.next(); // the new username that the user wants to set
        
        System.out.println("Enter new password");
        String newPassword = sc.next(); // the new password that the user wants to set
        
        // create a connection to the database using JDBC
        try{
            // create a prepared statement to update the login information for the specified user
            String sql = "UPDATE login SET username=?, password=? WHERE username=? and password=?";
            PreparedStatement statement = cc.prepareStatement(sql);
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, oldUsername);
            statement.setString(4, oldPassword);
            
            // execute the update statement
            int rowsUpdated = statement.executeUpdate();
            
            if(rowsUpdated==0){
                System.out.println("You have not entered valid UserID");
            }
            else{
                System.out.println("You have Successfully Updated Your Profile");
            }
            // print the number of rows that were updated
          //  System.out.println(rowsUpdated + " rows updated");
        } catch (SQLException ex) {
            System.err.println("Error updating login information: " + ex.getMessage());
        }
    }
    
    public boolean isValid(){
        Connect c=new Connect();
        Connection cc=c.connectivity();
        Scanner sc=new Scanner(System.in); 
        System.out.println("Enter Your User ID");
        String Username =sc.next(); 
        System.out.println("Enter Your Password");
        String Password =sc.next();
        
        // create a connection to the database using JDBC
        try{
            // create a prepared statement to update the login information for the specified user
            String sql = "select * from login where username=? and password=?";
            PreparedStatement statement = cc.prepareStatement(sql);
            statement.setString(1, Username);
            statement.setString(2, Password);
         
            ResultSet rs= statement.executeQuery();
            if(rs.next()){
                return true;
            }
           
        } catch (SQLException ex) {
            System.err.println("Error updating login information: " + ex.getMessage());
        }
         return false;
    }
    
    
}
