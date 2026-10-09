import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Start
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        
        // originally 15, 44
        Game game = new Game(15, 44, 3, "Easy");

        invincibleAnimation rainbowAnimation = new invincibleAnimation(game);
        Thread rainbowAnimationThread = new Thread(rainbowAnimation);
        rainbowAnimationThread.start();
        
        // originally 2000 milliseconds
        // testing is 3000
        generatePipes makePipes = new generatePipes(game, 2000);
        Thread makePipesThread = new Thread(makePipes);
        makePipesThread.start();
        
        // originally 100 milliseconds
        // testing is 200
        updateScreen refreshScreen = new updateScreen(game, 100, rainbowAnimation, makePipes);
        Thread refreshScreenThread = new Thread(refreshScreen);
        refreshScreenThread.start();
        
        shootLaser makeLaser = new shootLaser(game, 50);
        Thread makeLaserThread = new Thread(makeLaser);
        makeLaserThread.start();

        while (!game.playerDied()){
            if (game.playerDied()){
                break;
            }
            
            System.out.println("Enter: ");
            userChoice = input.nextLine();
            
            if (userChoice.length() != 0 && userChoice.substring(userChoice.length() - 1, userChoice.length()).equalsIgnoreCase("w")){
                game.moveShip("Up");
                game.printScreen();
            }
            
            else if (userChoice.length() != 0 && userChoice.substring(userChoice.length() - 1, userChoice.length()).equalsIgnoreCase("s")){
                game.moveShip("Down");
                game.printScreen();
            }
            
            else if (userChoice.length() != 0 && userChoice.substring(userChoice.length() - 1, userChoice.length()).equalsIgnoreCase("d") && game.getPipeScreen()[game.getShipRow()][game.getShipColumn() + 1].equals(" ")){
                game.getPipeScreen()[game.getShipRow()][game.getShipColumn() + 1] = "═";
                game.printScreen();
            }
        }
    }
    
    public static void wait(int milliseconds){
        try{
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch(Exception e){
        }
    }
}
