public class updateScreen implements Runnable{
    private int milliseconds;
    private String[][] pipeScreen;
    private String[][] screen;
    private Game game;
    private invincibleAnimation rainbowAnimation;
    private generatePipes makePipes;
    
    public updateScreen(Game game, int milliseconds, invincibleAnimation rainbowAnimation, generatePipes makePipes){
        this.game = game;
        this.milliseconds = milliseconds;
        this.rainbowAnimation = rainbowAnimation;
        this.makePipes = makePipes;

        pipeScreen = game.getPipeScreen();
        screen = game.getScreen();
    }
    
    public void changeSpeed(int milliseconds){
        this.milliseconds = milliseconds;
    }
    
    public void movePipesToLeft(){
        if (game.playerIsInvincible() && (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("|") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("‾") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("_") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("L") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("⅃") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("⌇"))){
            if (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("⌇")){
                pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
            }
            
            else if (game.getShipRow() == 1){
                pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("|") || pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("L") || pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("⅃")){
                    pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "T";
                }
                
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("T") && !pipeScreen[game.getShipRow() + 1][game.getShipColumn()].equals("‾")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                }
                
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn()].equals("T") && !pipeScreen[game.getShipRow() + 1][game.getShipColumn() - 1].equals("‾")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                    pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "‾";
                }
                
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn()].equals("‾") && !pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("T")){
                    pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "‾";
                }
                
                if (!pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("T") && pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("‾")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                }
            }
            
            else if (game.getShipRow() == game.getCanvasHeight() - 2){
                pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
                if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("|")){
                    pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "⊥";
                }
                
                if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("⊥") && !pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("_")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                }
                
                if (pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("⊥") && !pipeScreen[game.getShipRow() - 1][game.getShipColumn() - 1].equals("_")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                    pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "_";
                }
                
                if (pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("_") && !pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("⊥")){
                    pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "_";
                }
                
                if (!pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("⊥") && pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("_")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                }
            }

            else if (game.getShipRow() != game.getCanvasHeight() - 2 && (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("‾") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("|"))){
                pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("|") || pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("L") || pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("⅃")){
                    pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "T";
                    
                    if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("|")){
                        pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "⊥";
                    }
                    
                    else if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("‾")){
                        pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "=";
                    }
                    
                    else if (pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("_")){
                        pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "=";
                    }
                }
                
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("T") && !pipeScreen[game.getShipRow() + 1][game.getShipColumn()].equals("‾")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                }
                
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn()].equals("T") && !pipeScreen[game.getShipRow() + 1][game.getShipColumn() - 1].equals("‾")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                    pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "‾";
                    
                    if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals(" ") && (pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("⊥") || pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("_"))){
                        pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "_";
                    }
                    
                    else if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("‾")){
                        pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "=";
                    }
                }
                
                if (pipeScreen[game.getShipRow() + 1][game.getShipColumn()].equals("‾") && !pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("T")){
                    pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1] = "‾";
                    
                    if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals(" ") && (pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("⊥") || pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals("_"))){
                        pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "_";
                    }
                    
                    else if (pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("‾")){
                        pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "=";
                    }
                }
                
                if (!pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("T") && pipeScreen[game.getShipRow() + 1][game.getShipColumn() + 1].equals("‾")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "|";
                }
            }
            
            else if (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("L") || pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("|")){
                if (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("L") && pipeScreen[game.getShipRow() - 1][game.getShipColumn()].equals(" ")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "L";
                    pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "⊥";
                }
                
                else if (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("L") && !pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("|")){
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 2] = "L";
                    pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "_";
                }
                
                else if (pipeScreen[game.getShipRow()][game.getShipColumn() + 1].equals("L") && pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1].equals("|")){
                    pipeScreen[game.getShipRow() - 1][game.getShipColumn() + 1] = "⊥";
                    pipeScreen[game.getShipRow()][game.getShipColumn() + 1] = " ";
                }
            }
        }
        
        for (int row = 1; row < game.getCanvasHeight() - 1; row++){
            for (int column = 1; column < pipeScreen[0].length; column++){
                if (!pipeScreen[row][column].equals(" ")){
                    String oldCharacter = pipeScreen[row][column];
                    pipeScreen[row][column] = " ";
                    pipeScreen[row][column - 1] = oldCharacter;
                }
            }
        }
        
        for (int row = 1; row < game.getCanvasHeight(); row++){
            for (int column = 1; column < screen[0].length - 1; column++){
                screen[row][column] = pipeScreen[row][column];
            }
        }
        if (rainbowAnimation.getColorCode() == 0){
            screen[game.getShipRow()][game.getShipColumn()] = "\u001b[0m" + "𖤇";
        }
        else{
            screen[game.getShipRow()][game.getShipColumn()] = "\033[38;5;" + rainbowAnimation.getColorCode() + "m" + "𖤇" + "\u001b[0m";
        }
        
        for (int row = 1; row < game.getCanvasHeight() - 1; row++){
            if (screen[row][game.getShipColumn()].equals("_") && !screen[row][game.getShipColumn() + 1].equals("_")){
                game.setScore(game.getScore() + 1);
                
                if (game.getScore() % 1 == 0){
                    if (milliseconds - 1 >= 1){
                        milliseconds -= 1;
                    }
                    
                    // Pipes can spawn at the very least every 1200 milliseconds
                    if (makePipes.getTimeBetweenPipes() - 10 >= 1200){
                        makePipes.setTimeBetweenPipes(makePipes.getTimeBetweenPipes() - 10);
                    }
                }
            }
        }
        
        if (pipeScreen[game.getShipRow()][game.getShipColumn()].equals("✮")){
            pipeScreen[game.getShipRow()][game.getShipColumn()] = " ";
            game.toggleInvincibility(true);
            rainbowAnimation.restartCount();
        }
    }
    
    public void run(){
        while (true){
            
            if (game.shipHitPipe() || game.playerDied()){
                screen[game.getShipRow()][game.getShipColumn()] = "\033[38;5;160m" + "𖤇" + "\u001b[0m";
                
                for (String[] row : screen){
                    for (String column : row){
                        System.out.print(column);
                    }
                    System.out.println();
                }
                break;
            }
            
            try{
                movePipesToLeft();
                for (String[] row : screen){
                    for (String column : row){
                        System.out.print(column);
                    }
                    System.out.println();
                }
                Thread.sleep(milliseconds);
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.println("Score: " + game.getScore());
            }
            catch (InterruptedException e){
            }
        }
    }
}
