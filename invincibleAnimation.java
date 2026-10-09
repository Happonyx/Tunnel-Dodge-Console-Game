public class invincibleAnimation implements Runnable{
    private Game game;
    private String[][] screen;
    private String[][] pipeScreen;
    private int colorCode = 0;
    private int count = 0;
    
    public invincibleAnimation(Game game){
        this.game = game;
        this.screen = game.getScreen();
        this.pipeScreen = game.getPipeScreen();
    }
    
    public void changeShipColor(){
        if ((count >= 900 && count <= 950) || (count >= 1050 && count <= 1100) || (count >= 1200 && count <= 1250)){
            colorCode = 0;
            screen[game.getShipRow()][game.getShipColumn()] = "\033[38;5;" + colorCode + "m" + "𖤇" + "\u001b[0m";
        }
        
        else{
            screen[game.getShipRow()][game.getShipColumn()] = "\033[38;5;" + colorCode + "m" + "𖤇" + "\u001b[0m";
            colorCode++;
            
            if (colorCode == 231){
                colorCode = 0;
            }
        }
    }
    
    public int getColorCode(){
        return colorCode;
    }
    
    public void restartCount(){
        count = 0;
    }
    
    public void run(){
        while (true){
            if (game.playerIsInvincible()){
                changeShipColor();
                
                if (count == 1250){
                    count = 0;
                    game.toggleInvincibility(false);
                    colorCode = 0;
                }
                
                else{
                    count++;
                }
            }
            
            else{
                screen[game.getShipRow()][game.getShipColumn()] = "\u001b[0m" + "𖤇";
            }
            
            try{
                Thread.sleep(10);
            }
            catch (InterruptedException e){
            }
        }
    }
}
