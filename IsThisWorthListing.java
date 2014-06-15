/**
 * Is the Commodities Exchange sell order price only slightly more than you can vendor an item for?
 * Want to quickly check that it's worth it after the -12% Commodities Exchange cut? This can help!
 * 
 * Want to run this Java program, but don't have the Java JDK downloaded on your system?
 * Visit http://www.browxy.com/ and paste this code into the white window, press 'start', and respond
 * to the user prompts in the 'Console View' beneath it!
 * 
 * Anyone may modify this program however they see fit, with or without attribution.
 *
 * @author Courtney Thurston, http://www.courtneythurston.com
 * @version 1.0, 6/14/2014
 */

import java.util.*;
public class IsThisWorthListing
{
    public static void main (String[] args)
    {
        //Initializing variables
        int itemQuantity, copperVendor, silverVendor, goldVendor, platinumVendor, copperCE, silverCE, goldCE, platinumCE, vendorProfit, percentCut, vendorPriceInCopper, cePriceInCopper, totalVendorCopper, totalCECopper, totalCECopperAfterCut;
        
        //Initializing scanner
        Scanner in = new Scanner(System.in);
        
        //Prompting the user for input of quantity (static for vendor and CE)
        System.out.println("Enter the quantity of the item that you plan on selling:");
        itemQuantity = in.nextInt();
        System.out.println();
        
        //Prompting the user for input of vendor per-unit price information
        System.out.println("Enter the per-unit VENDOR price of this item. This is given correctly in your tradeskill bag and in the Commodities Exchange sell order window when you scroll over items.");
        System.out.println("Enter how many platinum coins are in the per-unit vendor price, if any:");
        platinumVendor = in.nextInt();
        System.out.println("Enter how many gold coins are in the per-unit vendor price, if any:");
        goldVendor = in.nextInt();
        System.out.println("Enter how many silver coins are in the per-unit vendor price, if any:");
        silverVendor = in.nextInt();
        System.out.println("Enter how many copper coins are in the per-unit vendor price, if any:");
        copperVendor = in.nextInt();
        System.out.println();
        
        //Prompting the user for input of CE per-unit price information
        System.out.println("Enter the current per-unit COMMODITIES EXCHANGE price of this item. The current competitive price can be found in the Commodities Exchange 'sell order' window.");
        System.out.println("Enter how many platinum coins are in the current per-unit CE price, if any:");
        platinumCE = in.nextInt();
        System.out.println("Enter how many gold coins are in the current per-unit CE price, if any:");
        goldCE = in.nextInt();
        System.out.println("Enter how many silver coins are in the current per-unit CE price, if any:");
        silverCE = in.nextInt();
        System.out.println("Enter how many copper coins are in the current per-unit CE price, if any:");
        copperCE = in.nextInt();
        System.out.println();
        
        //Calculating total vendor amount in copper (quantity * price)
        vendorPriceInCopper = copperVendor + 100 * (silverVendor + 100 * (goldVendor + 100 * platinumVendor));
        totalVendorCopper = vendorPriceInCopper * itemQuantity;
        
        //Calculating total CE amount in copper (quantity * price) and subtracting the CE's 12% cut
        cePriceInCopper = copperCE + 100 * (silverCE + 100 * (goldCE + 100 * platinumCE));
        totalCECopper = cePriceInCopper * itemQuantity;
        percentCut = totalCECopper * 12 / 100;
        totalCECopperAfterCut = totalCECopper - percentCut;
        
        //Converting the vendor copper amount back into individual WildStar currency types
        copperVendor = totalVendorCopper % 100;
        totalVendorCopper /= 100;
        silverVendor = totalVendorCopper % 100;
        totalVendorCopper /= 100;
        goldVendor = totalVendorCopper % 100;
        totalVendorCopper /= 100;
        platinumVendor = totalVendorCopper % 100;
        totalVendorCopper /= 100;
        
        //Converting the Commodities Exchange copper amount after CE cut back into individual WildStar currency types
        copperCE = totalCECopperAfterCut % 100;
        totalCECopperAfterCut /= 100;
        silverCE = totalCECopperAfterCut % 100;
        totalCECopperAfterCut /= 100;
        goldCE = totalCECopperAfterCut % 100;
        totalCECopperAfterCut /= 100;
        platinumCE = totalCECopperAfterCut % 100;
        totalCECopperAfterCut /= 100;
        
        //Printing vendor and CE total amounts
        System.out.println("The amount you would receive from vendoring the item is " + platinumVendor + " plat, " + goldVendor + " gold, " + silverVendor + " silver, " + copperVendor + " copper");
        System.out.println("The amount you would receive from selling the item at the current price on the Commodities Exchange is " + platinumCE + " plat, " + goldCE + " gold, " + silverCE + " silver, " + copperCE + " copper");
    }
}