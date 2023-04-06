import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sabin Reed", "44 College Ln, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5, true));
        myMap.addBuilding(new House("Chapin House", "50 Elm Street, Northampton, MA 01063", 5, true, false, 50));
        myMap.addBuilding(new House("Jordan House", "7 Paradise Road, Northampton, MA 01063", 4, false, false, 70));
        myMap.addBuilding(new House("King House", "10 Elm Street, Northampton, MA 01063", 4, true, true, 100));
        myMap.addBuilding(new House("Capen House", "26 Prospect Street, Northampton, MA 01063", 4, false, false, 60));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 1, 100, 100, 100, 100, false, 8, 20));
        myMap.addBuilding(new Cafe("Campus Cafe", "1 Chapin Way, Northampton, MA 01063", 1, 100, 100, 100, 100, false, 8, 22));


    System.out.println(myMap);
        System.out.println(myMap);
    }
    
}
