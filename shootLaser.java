public class shootLaser implements Runnable{
    private Game game;
    private int milliseconds;
    private String[][] screen;
    private String[][] pipeScreen;

    public shootLaser(Game game, int milliseconds){
        this.game = game;
        this.milliseconds = milliseconds;
        this.screen = game.getScreen();
        this.pipeScreen = game.getPipeScreen();
    }
    
    public void moveLasers(){
        for (int row = 0; row < pipeScreen.length; row++){
            for (int column = pipeScreen[0].length - 1; column >= 0; column--){
                if (pipeScreen[row][column].equals("═") && (pipeScreen[row][column + 1].equals("|") || pipeScreen[row][column + 1].equals("L"))){
                    pipeScreen[row][column] = " ";
                }
                
                else if (pipeScreen[row][column].equals("═")){
                    pipeScreen[row][column] = " ";
                    if (column != game.getCanvasWidth() - 1){
                        pipeScreen[row][column + 1] = "═";
                    }
                    
                    else if (pipeScreen[row][column + 1].equals("⌇")){
                        pipeScreen[row][column + 1] = " ";
                    }
                }
                
            }
        }
    }
    
    public void run(){
        while (true){
            moveLasers();

            try{
                Thread.sleep(milliseconds);
            }
            catch (InterruptedException e){
            }
        }
    }
}
