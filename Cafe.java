/**
 * The Cafe class represents a cafe that sells coffee to customers
 * The Cafe class extends the Building class and adds the functionality of a cafe
 */

public class Cafe extends Building {

    private boolean hasElevator;

    private int activeFloor;

    /** The number of coffee ounces in the cafe's inventory */
    private int nCoffeeOunces;

    /** The number of sugar packets in the cafe's inventory */
    private int nSugarPackets;

    /** The number of cream containers in the cafe's inventory */
    private int nCreams;

    /** The number of cups in the cafe's inventory */
    private int nCups;

    /** The opening time of the cafe in 24-hour format. */
    private int openingTime;

    /** The closing time of the cafe in 24-hour format. */
    private int closingTime;


    /**
     * Creates a new Cafe with the given name, address, number of floors, and inventory levels
     *
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the cafe
     * @param nCoffeeOunces the number of coffee ounces in the cafe's inventory
     * @param nSugarPackets the number of sugar packets in the cafe's inventory
     * @param nCreams the number of cream containers in the cafe's inventory
     * @param nCups the number of cups in the cafe's inventory
     * @param hasElevator whether or not the cafe has an elevator
     */

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        this.activeFloor = 1;
    }

    /**
     * Creates a new Cafe with the given name, address, number of floors, inventory levels, opening and closing times.
     *
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the cafe
     * @param nCoffeeOunces the number of coffee ounces in the cafe's inventory
     * @param nSugarPackets the number of sugar packets in the cafe's inventory
     * @param nCreams the number of cream containers in the cafe's inventory
     * @param nCups the number of cups in the cafe's inventory
     * @param hasElevator whether or not the cafe has an elevator
     * @param openingTime the opening time of the cafe in 24-hour format
     * @param closingTime the closing time of the cafe in 24-hour format
     */

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator, int openingTime, int closingTime) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        this.activeFloor = 1;
        this.openingTime = 8;
        this.closingTime = 22;
    }

    public boolean isOpen(int hour) {
        return hour >= openingTime && hour < closingTime;
    }

    /**
     * Sells a coffee of a given size with the specified number of sugar packets and cream containers to a customer
     * Restocks inventory if needed
     *
     * @param size the size of the coffee in ounces
     * @param nSugarPackets the number of sugar packets to add to the coffee
     * @param nCreams the number of cream containers to add to the coffee
     */

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        int coffeeNeeded = size;
        int sugarNeeded = nSugarPackets;
        int creamNeeded = nCreams;
        int cupsNeeded = 1;

        if (this.nCoffeeOunces < coffeeNeeded || this.nSugarPackets < sugarNeeded || this.nCreams < creamNeeded || this.nCups < cupsNeeded) {
            restock(coffeeNeeded, sugarNeeded, creamNeeded, cupsNeeded);
        }

        this.nCoffeeOunces -= coffeeNeeded;
        this.nSugarPackets -= sugarNeeded;
        this.nCreams -= creamNeeded;
        this.nCups -= cupsNeeded;

        System.out.println("Here's your coffee! Enjoy.");
    }

    /**
     * Sells a coffee of a given size with default sugar packets and cream containers to a customer
     * Restocks inventory if needed
     *
     * @param size the size of the coffee in ounces
     */

    
    public void sellCoffee(int size) {
        int sugarNeeded = 1; // Default value of 1 sugar packet
        int creamNeeded = 1; // Default value of 1 cream container
        
        sellCoffee(size, sugarNeeded, creamNeeded); // Call the original sellCoffee method with default values
    }

    /**
     * Restocks the cafe's inventory with the given amounts of coffee, sugar packets, cream containers, and cups
     *
     * @param nCoffeeOunces the number of coffee ounces to add to the inventory
     * @param nSugarPackets the number of sugar packets to add to the inventory
     * @param nCreams the number of cream containers to add to the inventory
     * @param nCups the number of cups to add to the inventory
     */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        System.out.println("Restocking inventory...");
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Returns the amount of coffee ounces currently in stock.
     *
     * @return the amount of coffee ounces currently in stock
     */

    public int getCoffeeOunces() {
        return this.nCoffeeOunces;
    }

    /**
     * Returns the number of sugar packets currently in stock.
     *
     * @return the number of sugar packets currently in stock
     */

    public int getSugarPackets() {
        return this.nSugarPackets;
    }

    /**
     * Returns the number of cream packets currently in stock.
     *
     * @return the number of cream packets currently in stock
     */

    public int getCreams() {
        return this.nCreams;
    }

    /**
     * Returns the number of cups currently in stock.
     *
     * @return the number of cups currently in stock
     */

    public int getCups() {
        return this.nCups;
    }

    /**
     * Prints the current inventory levels of coffee, sugar, cream, and cupsx
     */

    public void printInventory() {
        System.out.println("Coffee Ounces: " + this.nCoffeeOunces);
        System.out.println("Sugar Packets: " + this.nSugarPackets);
        System.out.println("Creams: " + this.nCreams);
        System.out.println("Cups: " + this.nCups);
    }

    /**
     * Moves the customer to the specified floor of the Cafe.
     * 
     * @param floorNum The floor number to navigate to
     * @throws RuntimeException If the customer is not inside the Cafe, if the Cafe only has one floor, 
     *                           if the floor number is invalid, or if the Cafe does not have an elevator 
     *                           and the customer is trying to move to a non-adjacent floor.
     */

    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this cafe. Must call enter() before navigating between floors.");
        }
        if (this.activeFloor != 1) {
            throw new RuntimeException("You cannot move to another floor. This Cafe only has one floor.");
        }
        if (floorNum < 1 || floorNum > 1) {
            throw new RuntimeException("Invalid floor number. Valid range for this Cafe is 1-1.");
        }
        if (floorNum != 1 && !hasElevator) {
            throw new RuntimeException("This cafe does not have an elevator. You cannot move between non-adjacent floors.");
        }
        System.out.println("You are now on floor #" + floorNum + " of the Cafe.");
        this.activeFloor = floorNum;
    }

    /**
     * Displays the options available to the customer at the Cafe.
     */

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("Cafe options:");
        System.out.println("1. Buy coffee: Choose size of coffee, amount of sugar packets and amount of creams for coffee");
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Campus Cafe", "1 Chapin Way Northampton MA", 1, 50, 50, 50, 50, true);

        // Show Cafe options

        cafe.showOptions();
    
        // Print initial inventory
        System.out.println("Initial inventory:");
        cafe.printInventory();
        System.out.println();
    
        // Sell a cup of coffee
        System.out.println("Selling a cup of coffee...");
        cafe.sellCoffee(12, 2, 3);
    
        // Print updated inventory
        System.out.println("Updated inventory:");
        cafe.printInventory();
        System.out.println();
    
        // Try to sell a cup of coffee with insufficient ingredients
        System.out.println("Trying to sell a cup of coffee with insufficient ingredients...");
        cafe.sellCoffee(46, 3, 4);
    
        // Print updated inventory
        System.out.println("Inventory after attempted sale:");
        cafe.printInventory();
        System.out.println();
    
        // Restock ingredients and print updated inventory
        System.out.println("Restocking...");
        cafe.restock(50, 50, 50, 50);
        System.out.println("Inventory after restocking:");
        cafe.printInventory();

        cafe.goToFloor(1);
        cafe.goToFloor(2);
    }
    
}
