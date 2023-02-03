import java.util.ArrayList;

public class Story {
    
    public static int currentChapter; // determines, which chapter is currently active
    static Player p = GameEngine.players.get(0); // load player from gameengine

    public static void startStory(ArrayList locationsLeft) {

        GameEngine.clearConsole();
        GameEngine.printMessage("bold", "blue", "The haunted Kingdom");
        GameEngine.printMessage("plain", "default", "The kingdom is haunted by evil, murderous monsters.");
        GameEngine.printMessage("plain", "default", "They have already taken control of many of our territories.");
        GameEngine.printMessage("plain", "default", "As a noble knight, it's your task to free all the captured places from the creatures.");
        GameEngine.printEmptyLine();

        Location.locationMenu(); // load location menu, so user can decide on next location
    }

    public static void playChapter(int id) {
        
        // switch statement to determine which storeyChapter should be loaded
        switch(id){
            case 1:
                currentChapter = 1;
                chapterOne();
                break;
            case 2:
                currentChapter = 2;
                chapterTwo();
                break;
            case 3:
                currentChapter = 3;
                chapterThree();
                break;
            case 4:
                currentChapter = 4;
                chapterFour();
                break;
            case 5:
                currentChapter = 5;
                chapterFive();
                break;
        }

    }

    public static void chapterOne() {

        // monsters are being spawned in the location
        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Skeleton", 100, 10);
        Location.spawnMonster(3, "Zombie", 75, 25);

        GameEngine.printEmptyLine();
        GameEngine.printMessage("bold", "blue", "Dungeon:");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        
        // run fight encounters (user gets attacked by monster)
        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);

        Combat.fightEncounter(p, m1);
        Combat.fightEncounter(p, m2);
        Combat.fightEncounter(p, m3);

        Location.locationCompleted(currentChapter);
    }

    public static void chapterTwo() {

        // monsters are being spawned in the location
        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Zombie", 75, 25);

        // print story segment
        GameEngine.printEmptyLine();
        GameEngine.printMessage("bold", "blue", "Market:");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        // run fight encounters (user gets attacked by monster)
        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);

        Combat.fightEncounter(p, m1);
        Combat.fightEncounter(p, m2);
        Combat.fightEncounter(p, m3);
        Combat.fightEncounter(p, m4);

        Location.locationCompleted(currentChapter);
    }

    public static void chapterThree() {

        // monsters are being spawned in the location
        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Zombie", 75, 25);
        Location.spawnMonster(5, "Spider", 125, 25);

        // print story segment
        GameEngine.printEmptyLine();
        GameEngine.printMessage("bold", "blue", "Smithy:");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        // run fight encounters (user gets attacked by monster)
        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);
        Monster m5 = Location.monsters.get(4);

        Combat.fightEncounter(p, m1);
        Combat.fightEncounter(p, m2);
        Combat.fightEncounter(p, m3);
        Combat.fightEncounter(p, m4);
        Combat.fightEncounter(p, m5);

        Location.locationCompleted(currentChapter);
    }

    public static void chapterFour() {

        // monsters are being spawned in the location
        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Zombie", 75, 25);
        Location.spawnMonster(4, "Spider", 75, 25);
        Location.spawnMonster(4, "Spider", 125, 25);

        // print story segment
        GameEngine.printEmptyLine();
        GameEngine.printMessage("bold", "blue", "Forest:");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        // run fight encounters (user gets attacked by monster)
        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);
        Monster m5 = Location.monsters.get(4);

        Combat.fightEncounter(p, m1);
        Combat.fightEncounter(p, m2);
        Combat.fightEncounter(p, m3);
        Combat.fightEncounter(p, m4);
        Combat.fightEncounter(p, m5);

        // set level as completed 
        Location.locationCompleted(currentChapter);
    }

    public static void chapterFive() {

        // monsters are being spawned in the location
        Location.spawnMonster(1, "Skeleton", 100, 10);
        Location.spawnMonster(2, "Zombie", 75, 25);
        Location.spawnMonster(3, "Spider", 125, 25);
        Location.spawnMonster(4, "Spider", 125, 25);
        Location.spawnMonster(5, "Spider", 125, 25);

        // print story segment
        GameEngine.printEmptyLine();
        GameEngine.printMessage("bold", "blue", "Lake:");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");
        GameEngine.printMessage("plain", "default", "// Insert Textblock");

        // run fight encounters (user gets attacked by monster)
        Monster m1 = Location.monsters.get(0);
        Monster m2 = Location.monsters.get(1);
        Monster m3 = Location.monsters.get(2);
        Monster m4 = Location.monsters.get(3);
        Monster m5 = Location.monsters.get(4);

        Combat.fightEncounter(p, m1);
        Combat.fightEncounter(p, m2);
        Combat.fightEncounter(p, m3);
        Combat.fightEncounter(p, m4);
        Combat.fightEncounter(p, m5);

        Location.locationCompleted(currentChapter);
    }
}
