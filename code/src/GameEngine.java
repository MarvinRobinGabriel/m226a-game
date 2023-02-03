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
    // fontstyles used in printMessage(util)
    public static final String textPlain = "\033[0;0m";
    public static final String textBold = "\033[0;1m";

    public static ArrayList<Player> players = new ArrayList<Player>(); // used to store player(s)
    public static ArrayList<Location> locations = new ArrayList<Location>(); // used to store all locations
    public static ArrayList<Location> locationsLeft = new ArrayList<Location>(); // stores only uncompleted locations

    // util to clear console, useful to avoid chaos
    public final static void clearConsole() {
        System.out.println("\033[H\033[2J");
    }

    // util to easily print single color messages
    public final static void printMessage(String type, String color, String message) {

        // make text plain/bold based on params
        String textVariant = "";

        if (type == "plain") {
            textVariant = "\033[0;0m";
        } else if (type == "bold") {
            textVariant = "\033[0;1m";
        }

        // switch color based on params
        switch (color) {
            case "default":
                System.out.println(textVariant + message + textPlain);
                break;
            case "blue":
                System.out.println(textVariant + colorBlue + message + colorReset + textPlain);
                break;
            case "red":
                System.out.println(textVariant + colorRed + message + colorReset + textPlain);
                break;
            case "yellow":
                System.out.println(textVariant + colorYellow + message + colorReset + textPlain);
                break;
            case "green":
                System.out.println(textVariant + colorGreen + message + colorReset + textPlain);
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

        // print text segments based on params
        switch (type) {
            case "title":
                clearConsole();
                printMessage("bold", "blue", "m226a - Textbased Adventure Game");
                printEmptyLine();
                break;
            case "about":
                clearConsole();
                printMessage("bold", "blue", "About this Project:");
                printMessage("plain", "default", "Developer: Marvin Robin Gabriel");
                printMessage("plain", "default", "Development Period: 27.01.2023 - 03.02.2022");
                printMessage("plain", "default", "Environment: Technische Berufsschule Zürich, m226a");
                printEmptyLine();
                printMessage("plain", "default", "Codebase: https://github.com/MarvinRobinGabriel/m226a-game/tree/main/code");
                printMessage("plain", "default", "Docs: https://github.com/MarvinRobinGabriel/m226a-game/tree/main/docs");
                printEmptyLine();
                break;
        }
    }

    // location creation
    public static void createLocation(int id, String title, boolean completed) {

        Location loc;
        loc = new Location();

        // assign values
        loc.id = id;
        loc.title = title;
        loc.completed = completed;

        // add loc to ArrayLists
        locations.add(loc);
        locationsLeft.add(loc);
    }

    // generate initial locations
    public static void locationFactory() {
        // gemerate an initial 5 locations
        createLocation(1, "Dungeon", false);
        createLocation(2, "Market", false);
        createLocation(3, "Smithy", false);
        createLocation(4, "Forest", false);
        createLocation(5, "Location", false);
    }

    // location rendeering process (used to load location)
    public static void renderLocation(int id) {
        Location loc;
        loc = locations.get(id);
        Location.enterLocation(id);
    }

    // menu, where user can choose next location to visit
    public static void locationMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean repeat = true; // whilst true: menu will continue to ask for input and won't load location
    
        while ( repeat ) {
            printMessage("bold", "blue", "Where would you like to go?");
            printMessage("plain", "default", "1) Dungeon");
            printMessage("plain", "default", "2) Market");
            printMessage("plain", "default", "3) Smithy");
            printMessage("plain", "default", "4) Forest");
            printMessage("plain", "default", "5) Lake");
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
                    printMessage("plain", "red", "Please enter a number from the provided options");
                return;
            }
        }
       }

    // mark location as completed and remove from remaining ArrayList
    public static void locationCompleted(int id) {
        Location loc;
        loc = locations.get(id);
        Location.completed = true; // mark location as completed

        System.out.println(textBold + colorGreen + Location.title + " has been freed from the monsters!" + colorReset + textPlain);
        printEmptyLine();
        locationMenu(); // load location menu, so user can move to another location

        locationsLeft.remove(loc); // remove location from ArrayList
    }

    // game completion segment
    public static void Completion() {
        clearConsole();
        printMessage("bold", "green", "Congratulations");
        printMessage("bold","green", "You managed to survive and beat the game!");
        printEmptyLine();
        App.menu(); // print main menu
    }

    // gameover segment
    public static void GameOver(String monster, int health) {
        clearConsole();
        printMessage("bold", "red", "Game Over");
        System.out.println( "You have been killed by a " + monster + "(" + health + "HP)" + colorReset);
        printMessage("plain", "default", "You might want to try harder next time!");
        printEmptyLine();
        App.menu(); // print main menu
    }

    // player creation
    public static void createPlayer() {

        String firstname;
        String lastname;
        Scanner sc = new Scanner(System.in);
        printEmptyLine();

        // firstname input
        while (true) {
            printMessage("bold", "blue", "Please enter your firstname");
            firstname = sc.next();
            if (firstname.length() < 2){
                printMessage("plain", "red", "Input isn't long enough!");
                printEmptyLine();
                continue;
            } 
            else if (!firstname.matches("[a-zA-Z]+")){
                printMessage("plain", "red", "Input contains forbidden characters!");
                printEmptyLine();
                continue;
            }
            else {
                printEmptyLine();
                break;
            }
        }

        // lastname input
        while (true) {
            printMessage("bold", "blue", "Please enter your lastname");
            lastname = sc.next();
            if (lastname.length() < 2){
                printMessage("plain", "red", "Input isn't long enough!");
                printEmptyLine();
                continue;
            }
            else if (!lastname.matches("[a-zA-Z]+")){
                printMessage("plain", "red", "Input contains forbidden characters!");
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
            System.out.println(textBold + colorBlue + "Would you like to continue as " + fullname + "? (yes to continue / no to abort)" + colorReset + textPlain);
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
                printMessage("plain", "red", "Please choose between yes and no");
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
        // health & damage is currently not changeable. Difficulty Selection could easily be implemented later down the line
        p.health = 150;
        p.damage = 20;

        // store newly created player
        players.add(p);

        // start story with all remaining locations
        Story.startStory(locationsLeft);

    }

}
