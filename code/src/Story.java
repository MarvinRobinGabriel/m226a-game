import java.util.ArrayList;

public class Story {
    
    public static int currentLocation;
    static Player p = GameEngine.players.get(0);

    public static void startStory(ArrayList locationsLeft) {
        GameEngine.clearConsole();
        GameEngine.printMessage("blue", "The kingdom is haunted by evil, murderous monsters.");
        GameEngine.printMessage("blue", "They have already taken control of many of our territories.");
        GameEngine.printMessage("blue", "As a noble knight, it's your task to free all the captured places from the creatures.");
        GameEngine.printEmptyLine();
        GameEngine.locationMenu();
    }

    public static void playChapter(int id) {
        
        switch(id){
            case 1:
                locationOne();
                break;
            case 2:
                GameEngine.printMessage("red", "Location Undefined");
                break;
            case 3:
                GameEngine.printMessage("red", "Location Undefined");
                break;
            case 4:
                GameEngine.printMessage("red", "Location Undefined");
                break;
            case 5:
                GameEngine.printMessage("red", "Location Undefined");
                break;
        }

    }

    public static void locationOne() {

        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Skeleton", 100, 10);
        Location.spawnMonster(3, "Zombie", 75, 25);

        Monster m1 = Location.monsters.get(1);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("blue", "// Insert Textblock");
        GameEngine.printMessage("blue", "// Insert Textblock");
        GameEngine.printMessage("blue", "// Insert Textblock");

        Combat.fightEncounter(p, m1);
    }
}
