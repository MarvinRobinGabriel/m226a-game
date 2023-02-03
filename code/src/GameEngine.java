import java.awt.Color;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameEngine {

    // colors used in printMessage() util
    public static final String colorReset = "\u001B[0m";
    public static final String colorRed = "\u001B[31m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorYellow = "\u001B[33m";
    public static final String colorBlue = "\u001B[34m";

    public static ArrayList<Player> players = new ArrayList<Player>();
    public static ArrayList<Location> locations = new ArrayList<Location>();
    public static ArrayList<Location> locationsLeft = new ArrayList<Location>();

    public final static void clearConsole() {
        System.out.println("\033[H\033[2J");
    }

    // util to easily print single color messages
    public final static void printMessage(String color, String message) {
        switch (color) {
            case "default":
                System.out.println(message);
                break;
            case "blue":
                System.out.println(colorBlue + message + colorReset);
                break;
            case "red":
                System.out.println(colorRed + message + colorReset);
                break;
            case "yellow":
                System.out.println(colorYellow + message + colorReset);
                break;
            case "green":
                System.out.println(colorGreen + message + colorReset);
                break;
        }
    }

    // util to print empty line
    public final static void printEmptyLine()
    {
        System.out.println(" ");
    }

    // util to print segment based on cmd
    public final static void printSegment(String type) {

        switch (type) {
            case "title":
                clearConsole();
                printMessage("blue", "m226a - Adventure Game");
                printEmptyLine();
                printEmptyLine();
                printEmptyLine();
                break;
            case "about":
                clearConsole();
                printMessage("blue", "About this project:");
                printEmptyLine();
                printEmptyLine();
                printEmptyLine();
                break;
        }
    }

    // location creation
    public static void createLocation(int id, String title, boolean completed) {

        Location loc;
        loc = new Location();

        loc.id = id;
        loc.title = title;
        loc.completed = completed;

        locations.add(loc);
        locationsLeft.add(loc);
    }

    // generate initial locations
    public static void locationFactory() {
        createLocation(1, "Location 1", false);
        createLocation(2, "Location 2", false);
        createLocation(3, "Location 3", false);
        createLocation(4, "Location 4", false);
        createLocation(5, "Location 5", false);
    }

    // location rendeering process
    public static void renderLocation(int id) {

        Location loc;
        loc = locations.get(id);

        Location.enterLocation(id);
    }

    public static void locationMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean repeat = true;
    
        while ( repeat ) {
            GameEngine.printMessage("blue", "Where would you like to go?");
            GameEngine.printMessage("blue", "1) Location 1");
            GameEngine.printMessage("blue", "2) Location 2");
            GameEngine.printMessage("blue", "3) Location 3");
            GameEngine.printMessage("blue", "4) Location 4");
            GameEngine.printMessage("blue", "5) Location");
            choice = sc.nextInt();
    
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
                default:
                    repeat = true;
                    GameEngine.printMessage("red", "Please enter a number from the provided options");
                return;
            }
        }
       }

    public static void locationCompleted(int id) {

        Location loc;
        loc = locations.get(id);
        locationsLeft.remove(loc);

        GameEngine.clearConsole();
        GameEngine.printEmptyLine();
        System.out.println(GameEngine.colorBlue + "You have completed " + loc.title + "!" + GameEngine.colorReset);
        GameEngine.printEmptyLine();
        GameEngine.locationMenu();
    }

    // game completion segment
    public static void Completion() {
        GameEngine.clearConsole();
        GameEngine.printEmptyLine();
        GameEngine.printMessage("green", "Congratulations");
        GameEngine.printMessage("green", "You managed to survive and beat the game!");
        GameEngine.printEmptyLine();
        App.menu();
    }

    // gameover segment
    public static void GameOver() {
        GameEngine.printEmptyLine();
        GameEngine.printMessage("red", "Game Over");
        GameEngine.printMessage("red", "You have died and thus lost the game");
        GameEngine.printEmptyLine();
        App.menu();
    }

    // player creation
    public static void createPlayer() {

        String firstname;
        String lastname;
    
        Scanner sc = new Scanner(System.in);

        printEmptyLine();

        while (true) {
            printMessage("blue", "Please enter your firstname");
            firstname = sc.next();
            if (firstname.length() < 2){
                printMessage("red", "Input isn't long enough!");
                printEmptyLine();
                continue;
            }
            else if (!firstname.matches("[a-zA-Z]+")){
                printMessage("red", "Input contains forbidden characters!");
                printEmptyLine();
                continue;
            }
            else {
                printEmptyLine();
                break;
            }
        }

        while (true) {
            printMessage("blue", "Please enter your lastname");
            lastname = sc.next();
            if (lastname.length() < 2){
                printMessage("red", "Input isn't long enough!");
                printEmptyLine();
                continue;
            }
            else if (!lastname.matches("[a-zA-Z]+")){
                printMessage("red", "Input contains forbidden characters!");
                printEmptyLine();
                continue;
            }
            else {
                printEmptyLine();
                break;
            }
        }

        String fullname = firstname + " " + lastname;
        askForConfirmation(firstname, lastname, fullname);
    }

    // ask for comfirmation before creating player
    public static void askForConfirmation(String firstname, String lastname, String fullname) {
        
        boolean repeat = true;
        String input;
        Scanner sc = new Scanner(System.in);
        while (repeat)
        {
            System.out.println(colorBlue + "Would you like to continue as " + fullname + "? (yes to continue / no to abort)" + colorReset);
            input = sc.nextLine();

            switch(input){
            case "yes":
            case "YES":
            case "y":
            case "Y":
                repeat = false;
                savePlayer(firstname, lastname);
                break;
            case "no": 
            case "NO": 
            case "n":
            case "N":
                repeat = false;
                createPlayer();
                break;
            default:
                repeat = true;
                printEmptyLine();
                printMessage("red", "Please choose between yes and no");
                break;
            }
        }
    }

    // create player
    public static void savePlayer(String firstname, String lastname) {

        Player p = new Player();
        p.id = 0;
        p.firstname = firstname;
        p.lastname = lastname;
        p.health = 150;
        p.damage = 20;

        players.add(p);

        Story.startStory(locationsLeft);

    }

}
