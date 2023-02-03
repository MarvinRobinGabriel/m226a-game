import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        GameEngine.printSegment("title");
        menu();
    }

    // menu used to initiate game or handle other cmds
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean repeat = true; // whilst true: menu will continue to ask for input and won't load location

        while ( repeat ) {
            GameEngine.printMessage("bold", "blue", "Please enter your prefered number to continue:");
            GameEngine.printMessage("plain", "default", "1) Start Game");
            GameEngine.printMessage("plain", "default", "2) About this Project");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    repeat = false;
                    GameEngine.locationFactory(); // generate initial locations
                    GameEngine.createPlayer(); // start player creation process
                    break;
                case 2:
                    repeat = true;
                    GameEngine.printSegment("about"); // print predefined segment "about this project"
                    break;
                default: // simple error handling
                    repeat = true;
                    GameEngine.printMessage("plain", "red", "Please choose from the provided options");
                    return;
            }
        }
    }
}
