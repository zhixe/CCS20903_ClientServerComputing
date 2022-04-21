package classes; // Set current working directory.
import java.util.Scanner; // Import Scanner class from java utils.
import java.io.IOException; // Import IOException class from java io.
import java.text.DecimalFormat; // Import DecimalFormat class from java text.

public class surfaceAreaCircle 
{
    public void calSurAreaCircle()
    {   
        try (Scanner getInput = new Scanner(System.in)) 
        {
            clearScreen();
            System.out.println("C. To calculate the surface area of a circle based on the given radius.\n");
            System.out.println("Enter the radius value:");

            double radInput = getInput.nextDouble();      
            double calArea = area(radInput); // Invoke the method area() from the class surfaceAreaCircle and store the return value of the method to calArea variable.

            // Set decimal format to 4 decimal places.
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(4);

            clearScreen();
            System.out.println("C. To calculate the surface area of a circle based on the given radius.\n");
            System.out.println("Given radius value: " + radInput);
            System.out.println("Surface area of the circle is " + df.format(calArea) + ".");
            getInput.close(); // Close the Scanner class to avoid resource leak warning.
        }      
    }

    // Create a method to calculate the area of a circle based on the given radius.
    static double area(double radVal)
    {
        return (22 * radVal * radVal) / 7;
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
// public class surfaceAreaCircle 
// {
//     public static void main(String[] mainPage) throws InterruptedException 
//     {   
//         try (Scanner getInput = new Scanner(System.in)) 
//         {
//             clearScreen();
//             System.out.println("C. To calculate the surface area of a circle based on the given radius.\n");
//             System.out.println("Enter the radius value:");

//             double radInput = getInput.nextDouble();      
//             double calArea = area(radInput); // Invoke the method area() from the class surfaceAreaCircle and store the return value of the method to calArea variable.

//             // Set decimal format to 4 decimal places.
//             DecimalFormat df = new DecimalFormat();
//             df.setMaximumFractionDigits(4);

//             clearScreen();
//             System.out.println("C. To calculate the surface area of a circle based on the given radius.\n");
//             System.out.println("Surface area of the circle is " + df.format(calArea) + ".");getInput.close(); // Close the Scanner class to avoid resource leak warning.
//         }      
//     }
// 
//     static double area(double radVal)
//     {
//         return (22 * radVal * radVal) / 7;
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
