import java.util.Scanner;
import java.text.DecimalFormat; // VERY important if I actually want to be able to receive inputs and round to the nearest 2 decimal values

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##"); //Creating the Scanner and Decimal Format objects

        //Following portion is just declaring variables
        String name;
        int numberOfPeople;
        int tipPercentage;
        double itemCost;
        double totalCost;

        //This portion just collects the name, number of people, and tip percentage
        System.out.println("Hi, what is your name?");
        name = scan.nextLine(); //Stores answer as your name to welcome you
        System.out.println("Welcome " + name + "! How many people are in your group?");
        numberOfPeople = scan.nextInt(); //Stores number of people as int value
        scan.nextLine();
        System.out.println("What's the tip percentage? (0 - 100):");
        tipPercentage = scan.nextInt(); //Stores tip percentage as int
        scan.nextLine();

        //This portion is the math to how it gets the itemCosts and totalCosts
        System.out.println("Enter the total cost of those meals in dollars and cents, e.g. 12.50 (-1 to end):");
        itemCost = scan.nextDouble();
        scan.nextLine();
        totalCost = 0; // Initialize the totalCost, so you can add the other variables to it
        totalCost += itemCost;

        while (itemCost != -1) {
            System.out.println("Enter the total cost of those meals in dollars and cents, e.g. 12.50 (-1 to end):");
            itemCost = scan.nextDouble();
            scan.nextLine();
            if (itemCost != -1)
                {
                    totalCost += itemCost;
                }
            } // While the user input for the item cost is not equal to -1 it will scan the input then add itemCost to totalCost. As a way to counter it adding -1 at the end, I just put a if statement to make sure it never adds -1

            //This portion is the math and generated output for the tip, cost per person, etc. I initialize and declare the values here.

            System.out.println("---------------------");
            System.out.println("Total Bill Before Tip: $" + totalCost);
            System.out.println("Tip Percentage: " + tipPercentage + "%");
            double tip = totalCost * ((double) tipPercentage / 100); //Cast tip percentage to a double then divide by 100 then multiply by total cost
            String formattedTip = formatter.format(tip); //Round Tip to nearest 2 decimal values
            System.out.println("Total Tip: $" + formattedTip); //Print out that formattedTip instead of tip for the rounded nice clean value. That will be common among the rest of the printed values for it to be formatted
            String formattedTotalBill = formatter.format(totalCost + tip); //Did the math within the formatting for fewer lines of code
            System.out.println("Total Bill With Tip: $" + formattedTotalBill);
            double perPersonCost = totalCost / numberOfPeople;
            String formattedPerPersonCost = formatter.format(perPersonCost); //Guess I didn't to it for all of them, but I just chose to cause why not
            System.out.println("Per Person Cost Before Tip: $" + formattedPerPersonCost);
            double tipPerPerson = tip / numberOfPeople;
            String formattedTipPerPerson = formatter.format(tipPerPerson);
            System.out.println("Tip per person: $" + formattedTipPerPerson);
            String formattedTotalCostPerPerson = formatter.format(tipPerPerson + perPersonCost);
            System.out.println("Total Cost Per Person: $" + formattedTotalCostPerPerson);

            scan.close(); //Good practice
            //Program stops at here coulda included a return or exit statement but I hope you enjoyed it :P
        }
    }

