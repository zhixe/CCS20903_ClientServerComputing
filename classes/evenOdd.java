package classes; // Set current working directory.
import java.util.Scanner; // Import Scanner class from java utils.
import java.io.IOException; // Import IOException class from java io.

public class evenOdd // Construct evenOdd class for SCS A2 Question B
{
    public void calEvenOdd()
    {
        try (Scanner getInput = new Scanner(System.in)) 
        {      
            clearScreen();
            System.out.println("B. To check whether a given number is an odd or even number.\n");
            System.out.println("Enter any integer value:"); // Print out the instruction to the user.
            int num = getInput.nextInt(); // Store the input given by the user from getInput variable as a variable num and define it as integer data type.

            clearScreen();

            if(evenNum(num)) // Call the object of evenNum(num), then print out the even number result, else print out the odd number result.
            {
                System.out.println("B. To check whether a given number is an odd or even number.\n");
                System.out.println(num + " is an even number!");
            }
            else
            {
                System.out.println("B. To check whether a given number is an odd or even number.\n");
                System.out.println(num + " is an odd number!");
            }   
            
            getInput.close(); // Close the Scanner class to avoid resource leak warning.
        }
    }

    public static boolean evenNum(int number) // 2. Declare a method to verify even and odd numbers.
    {
        if(number % 2 == 0) // When the remainder of the variable number is equal to 0, then return the boolean value true as even number, else return the boolean value false as odd number.
        {
            return true;
        }
        else
        {
            return false;
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
// public class evenOdd // Construct evenOdd class for SCS A2 Question B
// {
//     public static void main(String[] mainPage) throws InterruptedException 
//     {
//         try (Scanner getInput = new Scanner(System.in)) 
//         {      
//             clearScreen();
//             System.out.println("B. To check whether a given number is an odd or even number.\n");
//             System.out.println("Enter any integer value:"); // Print out the instruction to the user.
//             int num = getInput.nextInt(); // Store the input given by the user from getInput variable as a variable num and define it as integer data type.

//             clearScreen();

//             if(evenNum(num)) // Call the object of evenNum(num), then print out the even number result, else print out the odd number result.
//             {
//                 System.out.println("B. To check whether a given number is an odd or even number.\n");
//                 System.out.println(num + " is an even number!");
//             }
//             else
//             {
//                 System.out.println("B. To check whether a given number is an odd or even number.\n");
//                 System.out.println(num + " is an odd number!");
//             }   
            
//             getInput.close(); // Close the Scanner class to avoid resource leak warning.
//         }
//     }

//     public static boolean evenNum(int number) // 2. Declare a method to verify even and odd numbers.
//     {
//         if(number % 2 == 0) // When the remainder of the variable number is equal to 0, then return the boolean value true as even number, else return the boolean value false as odd number.
//         {
//             return true;
//         }
//         else
//         {
//             return false;
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
