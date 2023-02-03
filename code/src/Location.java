import java.util.ArrayList;

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
