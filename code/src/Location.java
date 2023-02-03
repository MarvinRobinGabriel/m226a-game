import java.util.ArrayList;

public class Location {
    
    static int id;
    static String title;
    static Boolean completed;
    static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Location() {
        id = 0;
        title = " ";
        completed = false;
    }

    public static void enterLocation(int id) {
        if (!completed) {
            GameEngine.clearConsole();
            System.out.println(GameEngine.colorBlue + "Welcome to " + title + "!" + GameEngine.colorReset);
            Story.playChapter(id);
        }

        if (completed) {
            GameEngine.printEmptyLine();
            GameEngine.printMessage("green", "You've already completed everything in this stage!");
            GameEngine.printMessage("green", "Please select a different location to continue your adventure.");
            GameEngine.printEmptyLine();
            GameEngine.locationMenu();
        }
    }

    public static void spawnMonster(int id, String type, int health, int damage) {

        Monster m;
        m = new Monster();
        
        m.type = type;
        m.health = health;
        m.damage = damage;

        monsters.add(m);
    }

    public static void killMonster(int id) {
        Monster m;
        m = monsters.get(id);

        System.out.println(GameEngine.colorBlue + "You have slayed the " + m.type + "!" + GameEngine.colorReset);
        monsters.remove(m);
    
    }

}
