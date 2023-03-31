/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Quizapp;

import java.util.Scanner;

public class QuizApp {
    
    public static void main(String[] args) throws InterruptedException {
       
       Scanner sc=new Scanner(System.in);
        System.out.println("ONLINE EXAMINATION");
        
        Login l=new Login();
        // l.update();
       // l.updatingProfile();
      boolean start=true;
      while(start){
      
        System.out.println("1.Login\n2.ProfileUpdate\n");
        int choice =sc.nextInt();
        if(choice==1){
              boolean x=l.isValid();
              if(x==true){
                    System.out.println("Logged Succesfully");
                    System.out.println("Your Exam Is Starting");
                    System.out.println("This Exam Consists of 3 questions\n Your Time is 10 secs\n Try to answer within 10sec or else exam will end ");
                    Thread.sleep(1000);
                    Display d=new Display();
                    Display d2=new Display();
                    d2.start();
                    
                    d.questions();
              }
              else{
                   System.out.println("Enter Valid Login Details");
              }
            
        }
        if(choice==2){
           l.updatingProfile();
        }
        System.out.println("Do you want to Use Application Again");
        String option=sc.next();
        if(option.equals("no")){
            start=false;
        }
      }
    }
    
}
