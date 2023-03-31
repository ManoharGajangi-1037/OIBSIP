/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quizapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author manohar
 */
public class Connect {
     public Connection connectivity(){
        Connection con = null;
         try{
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","rgukt123");
          }
          catch(Exception e){
               System.out.println(e);
          }
         return con;
     }
             
}
