
package labexer1;

import java.util.Scanner;

public class LabExer1 {
    
    
    public static void plusFive(double num1, double num2){
        
        num1 = num1 + 5;
        num2 = num2 + 5;
    
        System.out.println(num1 + " and " + num2);
    }
 
    
    public static void timesTwo(double num1, double num2){
        
        num1 = num1 * 2;
        num2 = num2 * 2;
        
       System.out.println(num1 + " and " + num2);
    
    }
    
    public static void showSquared(double num1, double num2){
        
        num1 = num1 * num1;
        num2 = num2 * num2;
        
       System.out.println(num1 + " and " + num2);
        
    } 
    public static void computerPercent(double num1, double num2){
        double value = (num1 / num2) * 100;
                
        
        
        
       System.out.println(num1 + " is " + value + " percent of " + num2 );
    }
    
    public static void main(String[] args) {
        double num1 = 0, num2 = 0;
        LabExer1 object1 = new LabExer1();
        LabExer1 object2 = new LabExer1();
        LabExer1 object3 = new LabExer1();
        LabExer1 object4 = new LabExer1();
        
        
        Scanner scan = new Scanner(System.in);
        
     System.out.print("Entered by the user 1: "); 
     num1 = scan.nextDouble();
     
     System.out.print("Entered by the user 2: ");
     num2 = scan.nextDouble();
      
     System.out.println();
     
     System.out.println("-----PLUSFIVE OUTPUT-----");
     System.out.println();
     
     object1.plusFive(num1, num2);
     
     System.out.println();
     
     System.out.println("-----TIMESTWO OUTPUT-----");
     System.out.println();
     object2.timesTwo(num1, num2);
     
     System.out.println();
     
     System.out.println("-----SHOWSQUARED OUTPUT-----");
     System.out.println();
     object3.showSquared(num1, num2);
     
     System.out.println();
     
     System.out.println("-----COMPUTEPERCENT OUTPUT-----");
     System.out.println();
     object4.computerPercent(num1, num2);
     
     System.out.println();
     
     
     
     
     
     
     
     
        
    }
    
}
