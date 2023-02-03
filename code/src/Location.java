import java.util.ArrayList;
import java.util.Scanner;

public class Location {
    
    static int id;
    static String title;
    static Boolean completed;
    static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Location() {
        id = 0;
        title = "";
        completed = false;
    }

    // location rendeering process (used to load location)
    public static void renderLocation(int id) {
        Location.enterLocation(id);
    }

    // used to determine if location is completed already or if there is remaining content to be achieved 
     public static void enterLocation(int id) {
        GameEngine.clearConsole();
        Story.playChapter(id);

    /* if (completed) {
         GameEngine.clearConsole();
        GameEngine.printMessage("bold", "green", "You've already completed everything in this stage!");
        GameEngine.printMessage("bold", "green", "Please select a different location to continue your adventure.");
        GameEngine.printEmptyLine();
        GameEngine.locationMenu();
    } */
    }

    // menu, where user can choose next location to visit
    public static void locationMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean repeat = true; // whilst true: menu will continue to ask for input and won't load location
    
        while ( repeat ) {
            GameEngine.printMessage("bold", "blue", "Where would you like to go?");
            GameEngine.printMessage("plain", "default", "1) Dungeon");
            GameEngine.printMessage("plain", "default", "2) Market");
            GameEngine.printMessage("plain", "default", "3) Smithy");
            GameEngine.printMessage("plain", "default", "4) Forest");
            GameEngine.printMessage("plain", "default", "5) Lake");
            choice = sc.nextInt();
    
            // determine which location to load based on user input3
            switch(choice){
                case 1:
                    repeat = false;
                    renderLocation(1);
                    break;
                case 2:
                    repeat = false;
                    renderLocation(2);
                    break;
                case 3:
                    repeat = false;
                    renderLocation(3);
                    break;
                case 4:
                    repeat = false;
                    renderLocation(4);
                    break;
                case 5:
                    repeat = false;
                    renderLocation(5);
                    break;
                default: // simple error handling
                    repeat = true;
                    GameEngine.printMessage("plain", "red", "Please enter a number from the provided options");
                return;
            }
        }
       }

    // mark location as completed and remove from remaining ArrayList
    public static void locationCompleted(int id) {
        
        Location loc = GameEngine.locations.get(id);
        completed = true; // mark location as completed

        System.out.println(GameEngine.textBold + GameEngine.colorGreen + title + " has been freed from the monsters!" + GameEngine.colorReset + GameEngine.textPlain);
        GameEngine.printEmptyLine();
        locationMenu(); // load location menu, so user can move to another location

        GameEngine.locationsLeft.remove(loc); // remove location from ArrayList
    }


    // spawn monsters inside this location based on params
    // monster presets are a viable alternative to param-based creation in the future
    public static void spawnMonster(int id, String type, int health, int damage) {

        Monster m;
        m = new Monster();
        m.type = type;
        m.health = health;
        m.damage = damage;
        monsters.add(m);
    }

    // "kill monster" by removing it from the ArrayList
    public static void killMonster(int id) {
        Monster m;
        m = monsters.get(id);

        GameEngine.printEmptyLine();
        System.out.println(GameEngine.textBold + GameEngine.colorGreen + "You have slayed the " + m.type + "!" + GameEngine.colorReset + GameEngine.textPlain);
        monsters.remove(m);
    
    }

}
