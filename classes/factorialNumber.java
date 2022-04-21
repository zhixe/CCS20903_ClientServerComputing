package classes; // Set current working directory.
import java.util.Scanner; // Import Scanner class from java utils.
import java.io.IOException; // Import IOException class from java io.

public class factorialNumber // Construct factorialNo class for SCS A2 Question A 
{
    public void calFactNo() 
    {
        try (Scanner getInput = new Scanner(System.in)) 
        {
            clearScreen();
            System.out.println("A. To calculate and return the factorial of a given number.\n");
            System.out.println("Enter any integer value:"); // Print out the first instruction to the user.
            int inNum = getInput.nextInt(); // Store the input given by the user from getInput variable as a variable num1 and define it as integer data type.
            
            int i, fact = 1; // Define i and fact as an integer variable and set fact to value 1.
            for(i = 1; i <= inNum; i++) 
            {    
                fact = fact * i;    
            } 

            clearScreen();

            // Print out the result of the calculation.
            System.out.println("A. To calculate and return the factorial of a given number.\n");
            System.out.println("Factorial of given number " + inNum + " is " + fact + ".");           
            // getInput.close(); // Close the Scanner class to avoid resource leak warning.
        }
    }

    // Clear console screen method.
    public static void clearScreen() 
    {
        try 
        {
            if (System.getProperty("os.name").contains("Windows")) 
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else 
            {
                System.out.print("\033\143");
            }
        } 
        catch (IOException | InterruptedException ex) 
        {

        }
    }
}



// ======== TEST UNIT ========
// public class factorialNo
// {
    
//     public static void main(String[] mainPage) throws InterruptedException 
//     {
//         try (Scanner getInput = new Scanner(System.in)) 
//         {
//             clearScreen();
//             System.out.println("A. To calculate and return the factorial of a given number.\n");
//             System.out.println("Enter any integer value:"); // Print out the first instruction to the user.
//             int inNum = getInput.nextInt(); // Store the input given by the user from getInput variable as a variable num1 and define it as integer data type.
            
//             int i, fact = 1; // Define i and fact as an integer variable and set fact to 1 value.
//             for(i = 1; i <= inNum; i++) 
//             {    
//                 fact = fact * i;    
//             } 
//             clearScreen();
//             // Print out the result of the calculation.
//             System.out.println("A. To calculate and return the factorial of a given number.\n");
//             System.out.println("Factorial of given number " + inNum + " is " + fact + ".");           
//             scan.close(); // Close the Scanner class to avoid resource leak warning.
//         }
//     }

//     // Clear console screen method.
//     public static void clearScreen() 
//     {
//         try 
//         {
//             if (System.getProperty("os.name").contains("Windows")) 
//             {
//                 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//             }
//             else 
//             {
//                 System.out.print("\033\143");
//             }
//         } 
//         catch (IOException | InterruptedException ex) 
//         {

//         }
//     }
// }
