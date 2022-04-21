import java.util.Scanner; // import scanner class from java utils
import java.util.concurrent.TimeUnit; // import timeunit class from java utils concurrent
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException; // Import IOException class from java io.

public class Q_00_start 
{
    public void startMain() throws InterruptedException 
    {
        clearScreen();
        System.out.println("############################################");
        System.out.println("################# CHEAP APP ################");
        System.out.println("############################################\n");
        System.out.println("Hello there stranger! Welcome to Cheap App.");
        System.out.println("Don't be shy, come let's get some drinks.\n");
        System.out.println("Cheap App allows cheap people to use the");
        System.out.println("paid app without having to pay.\n");
        System.out.println("############################################");
        System.out.println("########## BUILT FOR CHEAP PEOPLE ##########");
        System.out.println("############################################");
        TimeUnit.SECONDS.sleep(5);

        Scanner scan = new Scanner(System.in);
        boolean repeat;

        do 
        {
            clearScreen();            
            repeat = false;
            System.out.println("#######[SCS ASSIGNMENT 2]#######\n");
            System.out.println("Please select any question from the list below.");
            System.out.println("Choose an integer from 1 to 5:");
            displayInstructions();

            String input = scan.next();
            String regex = "[+-]?[0-9]+"; // Check input whether it is an integer or not.
            Pattern p = Pattern.compile(regex); // Compile the regex into a pattern.
            Matcher m = p.matcher(input); // Match the pattern with the input.

            if (m.find() && m.group().equals(input)) // If input is an integer value, then continue to the next step.
            {
                int inputInt = Integer.parseInt(input); // Convert string to integer.

                if(inputInt > 0 && inputInt < 6) // If input is between 1 to 5 integer value.
                {
                    repeat = extracted(repeat, inputInt);
                }
                else // If input is NOT between 1 to 5 integer value, then display error message and break the statement.
                {
                    clearScreen();
                    System.out.println("#######[SCS ASSIGNMENT 2]#######\n");
                    System.out.println("Dude! you entered the wrong value!\nPlease try again and choose an integer between 1 to 5 only!");
                    break;
                }
            }
            else // If input is NOT an integer value, then display error message and break the statement.
            {
                clearScreen();
                System.out.println("#######[SCS ASSIGNMENT 2]#######\n");
                System.out.println("Dude! you entered the wrong value!\nPlease try again and choose an integer between 1 to 5 only!");
                break;
            }
            scan.close();
        } while(repeat);
    }

    private static boolean extracted(boolean repeat, int input) throws InterruptedException  
    {
        switch (input) 
        {
            case 1:
                Q_A.QA_Answer();
                break;

            case 2:
                Q_B.QB_Answer();
                break;

            case 3:
                Q_C.QC_Answer();
                break;

            case 4:
                Q_D.QD_Answer();
                break;

            case 5:
                clearScreen();
                System.out.println("Doggo: Goodbye my friend!");
                TimeUnit.SECONDS.sleep(5);
                break;    
                            
            default:
                repeat = true;
        }
        return repeat;
    }

    private static String displayInstructions()
    {
        System.out.println("[1]: Question A");
        System.out.println("[2]: Question B");
        System.out.println("[3]: Question C");
        System.out.println("[4]: Question D");
        System.out.println("[5]: Exit Cheap App\n");
        System.out.println("Your choice: ");
        return null;
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
// public class Q_00_start 
// {
//     public static void main(String[] mainPage) throws InterruptedException 
//     {
//         clearScreen();
//         System.out.println("############################################");
//         System.out.println("################# CHEAP APP ################");
//         System.out.println("############################################\n");
//         System.out.println("Hello there stranger! Welcome to Cheap App.");
//         System.out.println("Don't be shy, come let's get some drinks.\n");
//         System.out.println("Cheap App allows cheap people to use the");
//         System.out.println("paid app without having to pay.\n");
//         System.out.println("############################################");
//         System.out.println("########## BUILT FOR CHEAP PEOPLE ##########");
//         System.out.println("############################################");
//         TimeUnit.SECONDS.sleep(5);

//         Scanner scan = new Scanner(System.in);
//         boolean repeat;

//         do 
//         {
//             clearScreen();            
//             repeat = false;
//             System.out.println("#######[SCS ASSIGNMENT 2]#######\n");
//             System.out.println("Please select any question from the list below.");
//             System.out.println("Choose an integer from 1 to 5:");
//             displayInstructions();

//             String input = scan.next();
//             String regex = "[+-]?[0-9]+"; // Check input whether it is an integer or not.
//             Pattern p = Pattern.compile(regex); // Compile the regex into a pattern.
//             Matcher m = p.matcher(input); // Match the pattern with the input.

//             if (m.find() && m.group().equals(input)) // If input is an integer value, then continue to the next step.
//             {
//                 int inputInt = Integer.parseInt(input); // Convert string to integer.

//                 if(inputInt > 0 && inputInt < 6) // If input is between 1 to 5 integer value.
//                 {
//                     repeat = extracted(repeat, inputInt);
//                 }
//                 else // If input is NOT between 1 to 5 integer value, then display error message and break the statement.
//                 {
//                     clearScreen();
//                     System.out.println("#######[SCS ASSIGNMENT 2]#######\n");
//                     System.out.println("Dude! you entered the wrong value!\nPlease try again and choose an integer between 1 to 5 only!");
//                     break;
//                 }
//             }
//             else // If input is NOT an integer value, then display error message and break the statement.
//             {
//                 clearScreen();
//                 System.out.println("#######[SCS ASSIGNMENT 2]#######\n");
//                 System.out.println("Dude! you entered the wrong value!\nPlease try again and choose an integer between 1 to 5 only!");
//                 break;
//             }
//             scan.close();
//         } while(repeat);
//     }

//     private static boolean extracted(boolean repeat, int input) throws InterruptedException  
//     {
//         switch (input) 
//         {
//             case 1:
//                 Q_A.QA_Answer();
//                 break;

//             case 2:
//                 Q_B.QB_Answer();
//                 break;

//             case 3:
//                 Q_C.QC_Answer();
//                 break;

//             case 4:
//                 Q_D.QD_Answer();
//                 break;

//             case 5:
//                 clearScreen();
//                 System.out.println("Doggo: Goodbye my friend!");
//                 TimeUnit.SECONDS.sleep(10);
//                 break;    
                            
//             default:
//                 repeat = true;
//         }
//         return repeat;
//     }

//     private static String displayInstructions()
//     {
//         System.out.println("[1]: Question A");
//         System.out.println("[2]: Question B");
//         System.out.println("[3]: Question C");
//         System.out.println("[4]: Question D");
//         System.out.println("[5]: Exit Cheap App\n");
//         System.out.println("Your choice: ");
//         return null;
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