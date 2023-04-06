import java.util.Hashtable;

/**
 * The Library class stores and manages a collection of books
 * The Library class inherits from the Building class and adds functionality specific to libraries
 */

public class Library extends Building {

    private boolean hasElevator;

    /**
     * A Hashtable that stores a collection of books as well as their availability status
     */

    private Hashtable<String, Boolean> collection;

    /**
     * Constructor for the Library class
     *
     * @param name     the name of the library
     * @param address  the address of the library
     * @param nFloors  the number of floors in the library
     */

    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        collection = new Hashtable<String, Boolean>();
        this.hasElevator = hasElevator;
    }

    /**
     * Adds a new book to the library's collection
     *
     * @param title  the title of the book added
     */

     public void addTitle(String title) {
        if (collection.containsKey(title)) {
            System.out.println(title + " is already in the collection.");
        } else {
            collection.put(title, true);
            System.out.println("Added " + title + " to the collection.");
        }
    }

    /**

    Adds a new book to the collection with the given title and author.
    @param title the title of the book to be added
    @param author the author of the book to be added
    */
    
    public void addTitle(String title, String author) {
        String bookInfo = title + " by " + author;
        if (collection.containsKey(bookInfo)) {
            System.out.println(bookInfo + " is already in the collection.");
        } else {
            collection.put(bookInfo, true);
            System.out.println("Added " + bookInfo + " to the collection.");
        }
    }

    /**
    Adds a new book to the collection with the given title and author.
    @param title the title of the book to be added
    @param author the author of the book to be added
    @param isbn the isbn number of the book
    */

    public void addTitle(String title, String author, String isbn) {
        String bookInfo = title + " by " + author + " (ISBN: " + isbn + ")";
        if (collection.containsKey(bookInfo)) {
            System.out.println(bookInfo + " is already in the collection.");
        } else {
            collection.put(bookInfo, true);
            System.out.println("Added " + bookInfo + " to the collection.");
        }
    }
    
  /**
     * Removes a book from the library's collection
     *
     * @param title  the title of the book removed
     * @return       the title of the book removed, or null if the book was not found in the collection
     */
  
  public String removeTitle(String title) {
      if (!collection.containsKey(title)) {
          System.out.println(title + " is not in the collection.");
          return null;
      } else {
          collection.remove(title);
          System.out.println("Removed " + title + " from the collection.");
          return title;
      }
  }

  /**
     * Checks out a book from the library's collection
     *
     * @param title  the title of the book checked out
     */
  
  public void checkOut(String title) {
      if (!collection.containsKey(title)) {
          System.out.println(title + " is not in the collection.");
      } else if (!collection.get(title)) {
          System.out.println(title + " is already checked out.");
      } else {
          collection.put(title, false);
          System.out.println("Checked out " + title + ".");
      }
  }

  /**
     * Returns a book to the library's collection
     *
     * @param title  the title of the book returned
     */
  
  public void returnBook(String title) {
      if (!collection.containsKey(title)) {
          System.out.println(title + " is not in the collection.");
      } else if (collection.get(title)) {
          System.out.println(title + " is already available.");
      } else {
          collection.put(title, true);
          System.out.println("Returned " + title + ".");
      }
    }

    /**
     * Checks whether the library's collection contains a given book
     *
     * @param title  the title of the book being checked for
     * @return       true if the book is in the collection, false otherwise
     */

  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
}

    /**
     * Checks whether a given book is available in the library's collection
     *
     * @param title  the title of the book to be checked for availability
     * @return       true if the book is available, false if it is checked out or not in the collection
     */
    
    public boolean isAvailable(String title) {
        if (!this.containsTitle(title)) {
            return false;
        }
        return this.collection.get(title);
    }

    /**
     * Prints the collection of titles in the library along with their availability status.
     */

    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : this.collection.keySet()) {
            String status = (this.collection.get(title)) ? "Available" : "Checked Out";
            System.out.println("- " + title + " (" + status + ")");
        }
    }

    /**
     * Overrides the showOptions() method of the parent class (Library) to include options specific to a library 
     * Calls the showOptions() method of the parent class to display library options, and then displays additional book-specific options:
     * Check out a book from the library's collection
     * Return a book to the library's collection
     * Print the entire collection of titles
    */

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("1: Check out a book from the library's collection");
        System.out.println("2: Return a book to the library's collection");
        System.out.println("3: Print the entire collection of titles");
    }

     /**
   * Moves the user to the specified floor within the library
   * @param floorNum the floor number to move to
   * @throws RuntimeException if the user has not entered the library yet, or if the floor number is invalid library does not have an elevator 
     *                           or if the student is trying to move to a non-adjacent floor
   */

    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this library. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this library is 1-" + this.nFloors +".");
        }
        if (floorNum != 1 && !hasElevator) {
            throw new RuntimeException("This library does not have an elevator. You cannot move between non-adjacent floors.");
        }
        if (!hasElevator && Math.abs(this.activeFloor - floorNum) > 1) {
            throw new RuntimeException("You cannot move between non-adjacent floors without using the elevator. activeFloor = " + this.activeFloor + ", floorNum = " + floorNum);
        }
        System.out.println("You are now on floor #" + floorNum + " of this library.");
        this.activeFloor = floorNum;
      }

    

    public static void main(String[] args) {
        Library library = new Library("Neilson Library", "7 Neilson Drive, Northampton MA", 5, true);
        System.out.println(library);

        // Add some books to the collection
        library.addTitle("The Great Gatsby ", "F. Scott Fitzgerald ", "123456789");
        library.addTitle("The Song of Achilles by Madeline Miller");
        library.addTitle("The Vanishing Half by Brit Bennett");
        library.addTitle("Pride and Prejudice by Jane Austen");

        library.addTitle("The Great Gatsby");
        library.addTitle("1984", "George Orwell", "123456789");

        
        // Print the entire collection
        library.printCollection();

        // Show Library Options

        library.showOptions();

        // Check if a title is in the collection
        System.out.println("Contains 'The Song of Achilles by Madeline Miller': " + library.containsTitle("The Song of Achilles by Madeline Miller"));
  
        // Check if a title is available
        System.out.println("Is 'The Great Gatsby by F. Scott Fitzgerald' available: " + library.isAvailable("The Great Gatsby by F. Scott Fitzgerald"));
  
        // Check out a book
        library.checkOut("The Vanishing Half by Brit Bennettl");
  
        // Print the entire collection again to see updated status
        library.printCollection();
        
        // Return a book
        library.returnBook("The Vanishing Half by Brit Bennett");
        
        // Print the entire collection again to see updated status
        library.printCollection();

        library.enter(); // enter the library to start at the ground floor
        library.goToFloor(3); // should output "You are now on floor #3 of Central Library"
        library.goToFloor(5); // should output "You are now on floor #5 of Central Library"
        library.goToFloor(2); // should output "You are now on floor #2 of Central Library"
        library.exit(); // exit the library to end the program
      }
    }




  