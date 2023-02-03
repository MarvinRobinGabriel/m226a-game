import java.util.ArrayList;

public class Story {
    
    public static int currentLocation;
    static Player p = GameEngine.players.get(0);

    public static void startStory(ArrayList locationsLeft) {
        GameEngine.clearConsole();
        GameEngine.printMessage("bold", "blue", "The haunted Kingdom");
        GameEngine.printMessage("plain", "default", "The kingdom is haunted by evil, murderous monsters.");
        GameEngine.printMessage("plain", "default", "They have already taken control of many of our territories.");
        GameEngine.printMessage("plain", "default", "As a noble knight, it's your task to free all the captured places from the creatures.");
        GameEngine.printEmptyLine();
        GameEngine.locationMenu();
    }

    public static void playChapter(int id) {
        
        switch(id){
            case 1:
                currentLocation = 1;
                locationOne();
                break;
            case 2:
                currentLocation = 2;
                locationTwo();
                break;
            case 3:
                currentLocation = 3;
                locationThree();
                break;
            case 4:
                currentLocation = 4;
                locationFour();
                break;
            case 5:
                currentLocation = 5;
                locationFive();
                break;
        }

    }

    public static void locationOne() {

        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Skeleton", 100, 10);
        Location.spawnMonster(3, "Zombie", 75, 25);

        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        Combat.fightEncounter(p, m1);
        // Combat.fightEncounter(p, m2);
        // Combat.fightEncounter(p, m3);

        GameEngine.locationCompleted(currentLocation);
    }

    public static void locationTwo() {

        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Zombie", 75, 25);

        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        Combat.fightEncounter(p, m1);
        // Combat.fightEncounter(p, m2);
        // Combat.fightEncounter(p, m3);
        // Combat.fightEncounter(p, m4);

        GameEngine.locationCompleted(currentLocation);
    }

    public static void locationThree() {

        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Zombie", 75, 25);
        Location.spawnMonster(5, "Spider", 125, 25);

        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);
        Monster m5 = Location.monsters.get(4);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        Combat.fightEncounter(p, m1);
        // Combat.fightEncounter(p, m2);
        // Combat.fightEncounter(p, m3);
        // Combat.fightEncounter(p, m4);
        // Combat.fightEncounter(p, m5);

        GameEngine.locationCompleted(currentLocation);
    }

    public static void locationFour() {

        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Spider", 75, 25);
        Location.spawnMonster(4, "Spider", 125, 25);

        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);
        Monster m5 = Location.monsters.get(4);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        Combat.fightEncounter(p, m1);
        // Combat.fightEncounter(p, m2);
        // Combat.fightEncounter(p, m3);
        // Combat.fightEncounter(p, m4);
        // Combat.fightEncounter(p, m5);

        GameEngine.locationCompleted(currentLocation);
    }

    public static void locationFive() {

        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Zombie", 75, 25);
        Location.spawnMonster(5, "Spider", 125, 25);
        Location.spawnMonster(6, "Spider", 125, 25);
        Location.spawnMonster(7, "Spider", 125, 25);

        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);
        Monster m5 = Location.monsters.get(4);
        Monster m6 = Location.monsters.get(5);
        Monster m7 = Location.monsters.get(6);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        Combat.fightEncounter(p, m1);
        // Combat.fightEncounter(p, m2);
        // Combat.fightEncounter(p, m3);
        // Combat.fightEncounter(p, m4);
        // Combat.fightEncounter(p, m5);
        // Combat.fightEncounter(p, m6);
        // Combat.fightEncounter(p, m7);

        GameEngine.locationCompleted(currentLocation);
    }
}
