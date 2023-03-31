/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quizapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author manohar
 */
public class Display extends Thread{
    static int Score=0;
    static int  count=0;
    public void run(){
        try{
          Thread.sleep(10000);
          if(count<3){
            System.out.println("Time Limit Exceeded");
            System.out.println("Your Score"+Score);
          }
        }
        catch(Exception e){
        
        }
    }
    public void questions(){
       Connect c=new Connect();
         Connection cc=c.connectivity();
          //String oldUsername = "newuser1"; // the old username that the user wants to change
        String Username = "user2"; // the new username that the user wants to set
        String Password = "password2"; // the new password that the user wants to set
        
        // create a connection to the database using JDBC
        Scanner sc=new Scanner(System.in);
        count=0;
        Score=0;
        try{
              Statement st=cc.createStatement();
          ResultSet rs=st.executeQuery("select * from quiz_questions");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"."+rs.getString(2)+"\n\n"+"1."+rs.getString(3)+"  2."+rs.getString(4)+"  3."+rs.getString(5)+"  5."+rs.getString(6));
            System.out.println("Enter your choice");
            int x=sc.nextInt();
            if(x==rs.getInt(7)){
                Score++;
            }
            count++;
        }
        System.out.println("You Scored "+Score);
        } catch (SQLException ex) {
            System.err.println("Error updating login information: " + ex.getMessage());
        }
    }
}
