package classes; // Set current working directory.
import java.util.Scanner; // Import Scanner class from java utils.
import java.io.IOException; // Import IOException class from java io.

public class stringLength 
{
    public void calStringLength()
    {
        try (Scanner getInput = new Scanner(System.in))
        {   
            clearScreen();
            System.out.println("D. To return the length of a given string.\n");
            System.out.print("Enter any value:\n");
            String stringInput = getInput.nextLine(); 

            clearScreen();
            System.out.println("D. To return the length of a given string.\n");
            System.out.println("The length of " + '"' + stringInput + '"' + " string is "+ lengthString(stringInput) + ".");

            getInput.close(); // Close the Scanner class to avoid resource leak warning.
        }
    }

    public static int lengthString(String str)
    {
        int length = 0; // Set the integer length variable to 0.
        char[] strCharArray = str.toCharArray(); // Convert the string to char array.

        for(char c : strCharArray) // Loop through the char array.
        {
            length++; // Increment the length variable by 1.
        }

        return length; // Return the length variable once the condition has been satisfied.
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
// public class stringLength 
// {
//     public static void main(String[] mainPage) throws InterruptedException 
//     {
//         try (Scanner getInput = new Scanner(System.in))
//         {   
//             clearScreen();
//             System.out.println("D. To return the length of a given string.\n");
//             System.out.println("Enter any value:");
//             String stringInput = getInput.next(); 

//             clearScreen();
//             System.out.println("D. To return the length of a given string.\n");
//             System.out.println("The length of " + '"' + stringInput + '"' + " string is "+ lengthString(stringInput) + ".");
// 
//             getInput.close(); // Close the Scanner class to avoid resource leak warning.
//         }
//     }

//     public static int lengthString(String str)
//     {
//         int length = 0;
//         char[] strCharArray = str.toCharArray();
//         for(char c : strCharArray)
//         {
//             length++;
//         }

//         return length;
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
