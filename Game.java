import java.util.ArrayList;

public class Game {
    private int canvasHeight;
    private int canvasWidth;
    private int pipeWidth;
    private int score;
    
    private int shipRow;
    private final int shipColumn = 7;
    private String difficulty;
    private boolean playerDied;
    private boolean invincibility;
    
    private String[][] screen;
    private String[][] pipeScreen;
    
    private final String aura = "                        " + "\n" + 
                                "                       " + "\n" + 
                                "                       " + "\n" + 
                                "        ╭╮◟            " + "\n" + 
                                "   c-(-C-╾== 𖤇         " + "\n" + 
                                "        ╰╯◜                " + "\n" + 
                                "                          " + "\n" + 
                                "                           " + "\n" + 
                                "                          " + "\n";
    
    private final String arrow =  "                        " + "\n" + 
                                  "                    " + "\n" + 
                                  "              ╱|               " + "\n" + 
                                  "            ╱  |____________           " + "\n" + 
                                  "       𖤇  <                |   " + "\n" + 
                                  "            ╲  |‾‾‾‾‾‾‾‾‾‾‾‾               " + "\n" + 
                                  "              ╲|             " + "\n" + 
                                  "                           " + "\n" + 
                                  "                          " + "\n";
                                
    
    public Game(int canvasHeight, int canvasWidth, int pipeWidth, String difficulty){
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        this.pipeWidth = pipeWidth;
        this.score = 0;
        
        shipRow = (int)(canvasHeight / 2.0 - 0.5);
        this.difficulty = difficulty;
        playerDied = false;
        invincibility = false;
        
        screen = new String[canvasHeight][canvasWidth];
        pipeScreen = new String[canvasHeight][canvasWidth + 16];
        
        for (int column = 0; column < canvasWidth; column++){
            screen[0][column] = "=";
            pipeScreen[0][column] = "=";
        }
        
        for (int column = canvasWidth - 1; column < canvasWidth + 16; column++){
            pipeScreen[0][column] = " ";
        }
        
        for (int row = 1; row < canvasHeight - 1; row++){
            screen[row][0] = "|";
            pipeScreen[row][0] = " ";
            for (int column = 1; column < canvasWidth - 1; column++){
                screen[row][column] = " ";
            }
            for (int column = 1; column < canvasWidth + 16; column++){
                pipeScreen[row][column] = " ";
            }
            screen[row][canvasWidth - 1] = "|";
        }
        
        for (int column = 0; column < canvasWidth; column++){
            screen[canvasHeight - 1][column] = "=";
            pipeScreen[canvasHeight - 1][column] = "=";
        }
        
        for (int column = canvasWidth - 1; column < canvasWidth + 16; column++){
            pipeScreen[canvasHeight - 1][column] = " ";
        }
        screen[shipRow][shipColumn] = "𖤇";
    }
    
    // work on this
    public void generatePipe(){
        int pipeGap = 0;
        switch (difficulty){
            case "Easy": pipeGap = 3; break;
            case "Normal": pipeGap = 2; break;
            case "Hard": pipeGap = 1; break;
        }
        
        int pipeHeight = (int)(Math.random() * ((canvasHeight - 3) - pipeGap) + 1);
        Pipe pipe = new Pipe(pipeHeight, pipeWidth, pipeGap, canvasHeight);

        for (int row = 0; row < canvasHeight - 2; row++){
            for (int column = 0; column < pipeWidth + 2; column++){
                pipeScreen[row + 1][column + screen[0].length + 1] = pipe.getPipe()[row][column];
            }
        }
    }
    
    public void moveShip(String direction){
        if (direction.equals("Up")){
            if (!invincibility && (screen[shipRow - 1][shipColumn].equals("L") || screen[shipRow - 1][shipColumn].equals("_") || screen[shipRow - 1][shipColumn].equals("⅃"))){
                playerDied = true;
            }
            
            else if (shipRow != 1){
                screen[shipRow][shipColumn] = " ";
                screen[shipRow - 1][shipColumn] = "𖤇";
                shipRow--;
            }
        }
        
        else if (direction.equals("Down")){
            if (!invincibility && (screen[shipRow + 1][shipColumn].equals("|") || screen[shipRow + 1][shipColumn].equals("‾"))){
                playerDied = true;
            }
            
            else if (shipRow != canvasHeight - 2){
                screen[shipRow][shipColumn] = " ";
                screen[shipRow + 1][shipColumn] = "𖤇";
                shipRow++;
            }
        }
    }
    
    public void printScreen(){
        System.out.print("\u001B[2J" + "\u001B[0;0f");
        System.out.println("Score: " + score);
        for (String[] row : screen){
            for (String column : row){
                System.out.print(column);
            }
            System.out.println();
        }
    }
    
    public boolean shipHitPipe(){
        if (invincibility){
            return false;
        }
        else if (screen[shipRow][shipColumn + 1].equals("L") || screen[shipRow][shipColumn + 1].equals("|") || screen[shipRow][shipColumn + 1].equals("⌇")){
            playerDied = true;
            return true;
        }
        return false;
    }
    
    public boolean playerDied(){
        if (invincibility){
            playerDied = false;
            return false;
        }
        return playerDied;
    }
    
    public void toggleInvincibility(boolean status){
        invincibility = status;
    }
    
    public boolean playerIsInvincible(){
        return invincibility;
    }
    
    public String[][] getScreen(){
        return screen;
    }
    
    public String[][] getPipeScreen(){
        return pipeScreen;
    }
    
    public int getCanvasHeight(){
        return canvasHeight;
    }
    
    public void setCanvasHeight(int canvasHeight){
        this.canvasHeight = canvasHeight;
    }
    
    public int getCanvasWidth(){
        return canvasWidth;
    }
    
    public int getShipRow(){
        return shipRow;
    }
    
    public int getShipColumn(){
        return shipColumn;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
}
