/**
 * Brokering items on the Commodities Exchange and need to take a cut of the profit? This can help!
 * The WildStar Transaction Tool calculates profit after your percentage cut (input) has been taken!
 * 
 * Want to run this Java program, but don't have the Java JDK downloaded on your system?
 * Visit http://www.browxy.com/ and paste this code into the white window, press 'start', and respond
 * to the user prompts in the 'Console View' beneath it!
 * 
 * Anyone may modify this program however they see fit, with or without attribution.
 *
 * @author Courtney Thurston, http://www.courtneythurston.com
 * @version 1.1, 6/13/2014
 */
import java.util.*;
public class BrokerCutAssistant
{
    public static void main (String[] args)
    {
        //Initializing variables
        int totalCopper, copper, silver, gold, platinum, percent, percentCut, totalCopperAfterCut;
        
        //Initializing scanner
        Scanner in = new Scanner(System.in);
        
        //Prompting the user for input of transaction data
		System.out.println("Enter the number of platinum coins received in the transaction:"); 
        platinum = in.nextInt();
		System.out.println("Enter the number of gold coins received in the transaction:");
        gold = in.nextInt();
		System.out.println("Enter the number of silver coins received in the transaction:");
        silver = in.nextInt();
        System.out.println("Enter the number of copper coins received in the transaction:"); 
        copper = in.nextInt(); //Order of input prompts was reversed in version 1.0; fixed in version 1.1 for UX
		
		//Prompting the user for input of desired percentage cut
        System.out.println("Enter a whole percent, without the percentage sign, that should be subtracted from this amount.");
        System.out.println("For example, input 15 if you want a fifteen percent cut:"); 
        percent = in.nextInt();
        
        //Converting currency types into copper coins to enable easy percentage calculation
        totalCopper = copper + 100 * (silver + 100 * (gold + 100 * platinum));
        
        //Subtracting the percent from totalCopper
        percentCut = totalCopper * percent / 100;
        totalCopperAfterCut = totalCopper - percentCut;
        
        //Converting the copper amount back into individual WildStar currency types
        copper = totalCopperAfterCut % 100;
        totalCopperAfterCut /= 100;
        silver = totalCopperAfterCut % 100;
        totalCopperAfterCut /= 100;
        gold = totalCopperAfterCut % 100;
        totalCopperAfterCut /= 100;
        platinum = totalCopperAfterCut % 100;
        totalCopperAfterCut /= 100;
        
        //Printing transaction amount after conversion, percent subtraction, and re-conversion
        System.out.println("The amount after your percentage cut was subtracted is: " + platinum + " plat, " + gold + " gold, " + silver + " silver, " + copper + " copper");
    }
}
