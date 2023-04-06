import java.util.ArrayList;

/**
 * A House class represents a Smith dorm building that can be lived in by students and may have a dining hall
 * The House class extends the building class and adds the functionality of a house
 */

public class House extends Building {

  private int nFloors;
  private int activeFloor;
  private boolean hasElevator;

  /** The list of students who are currently residents of this house */
  private ArrayList<String> residents;

  /** Whether or not this house has a dining room */
  private boolean hasDiningRoom;

  private int roomsAvailable;

  /**
   * Creates a new House object with the given name, address, number of floors, and dining room status
   *
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors in the house
   * @param hasDiningRoom whether or not the house has a dining room
   * @param hasElevator whether or not the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.nFloors = nFloors;
    this.hasElevator = hasElevator;
    this.activeFloor = 1; // start on first floor by default
  }

  /**

  Creates a new House object with the given name, address, number of floors, dining room status, and number of available rooms.
  @param name the name of the house
  @param address the address of the house
  @param nFloors the number of floors in the house
  @param hasDiningRoom whether or not the house has a dining room
  @param hasElevator whether or not the house has an elevator
  @param roomsAvailable the number of available rooms in the house
  */

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator, int roomsAvailable) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.nFloors = nFloors;
    this.hasElevator = hasElevator;
    this.activeFloor = 1; // start on first floor by default
    this.roomsAvailable = roomsAvailable;
  }

/**
   * Returns whether or not this house has a dining room
   *
   * @return true if the house has a dining room, false otherwise
   */  
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents currently living in this house
   *
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Adds a new resident to this house
   *
   * @param name the name of the new resident
   * @throws RuntimeException if the new resident is already a resident of this house
   */
  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if not, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :)");
  }


public void moveIn(String name, int nResidents) {
    if (this.roomsAvailable < nResidents) {
        throw new RuntimeException("Sorry, there are not enough rooms available at " + this.name);
    }
    for (int i = 0; i < nResidents; i++) {
        this.moveIn(name + " " + (i+1));
    }
}

  /**
   * Removes a resident from this house
   *
   * @param name the name of the resident to remove
   * @throws RuntimeException if the named resident is not a resident of this house
   */

  public void moveOut(String name) {
    if (!this.residents.contains(name)) {
        throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    this.residents.remove(name);
    System.out.println(name + " has moved out of " + this.name + ". Go say goodbye :(");
}

  /**
   * Returns whether or not the given person is a resident of this house
   *
   * @param person the name of the person to check
   * @return true if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }  

  /**
   * Moves the user to the specified floor within the house
   * @param floorNum the floor number to move to
   * @throws RuntimeException if the user has not entered the house yet, or if the floor number is invalid house does not have an elevator 
     *                           or if the resident is trying to move to a non-adjacent floor
   */

@Override
public void goToFloor(int floorNum) {
  if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this house. Must call enter() before navigating between floors.");
  }
  if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this house is 1-" + this.nFloors +".");
  }
  if (floorNum != 1 && !hasElevator) {
      throw new RuntimeException("This house does not have an elevator. You cannot move between non-adjacent floors.");
  }
  if (!hasElevator && Math.abs(this.activeFloor - floorNum) > 1) {
      throw new RuntimeException("You cannot move between non-adjacent floors without using the elevator. activeFloor = " + this.activeFloor + ", floorNum = " + floorNum);
  }
  System.out.println("You are now on floor #" + floorNum + " of this house.");
  this.activeFloor = floorNum;
}

  /**
  * Displays the options available at a house at Smith College
  */
@Override
public void showOptions() {
    super.showOptions(); // Call the showOptions method of the parent class (Building)
    System.out.println("1. Move in");
    System.out.println("2. Move out");
    System.out.println("3. Go to different floors in the dorm");
}


  /**
   * Returns a String representation of this house, including its name, address, number of floors,
   * number of residents, and dining room status
   *
   * @return a String describing the house
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false, true, 20);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    //morrow.moveIn("Jordan"); // this should throw an exception
    morrow.moveIn("Taylor");
    System.out.println(morrow);
    morrow.moveOut("Jordan");
    System.out.println(morrow);

    // Call the showOptions method on the House object
    morrow.showOptions();

    
    morrow.goToFloor(1);
    morrow.goToFloor(3); // should work with elevator
    morrow.goToFloor(2); // should work with elevator
    morrow.goToFloor(1);
    
  

    House king = new House("King", "The Quad", 3, true, false);
    System.out.println(king);

    // Check if Jordan is a resident of Morrow
    System.out.println("Is Taylor a resident of Morrow? " + morrow.isResident("Taylor"));
    // Check if Alice is a resident of Morrow
    System.out.println("Is Jordan a resident of Morrow? " + morrow.isResident("Jordan"));


     
  


    
  }

  

}