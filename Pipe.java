import java.util.ArrayList;

public class Pipe {
    private int pipeHeight;
    private int pipeWidth;
    private int pipeGap;
    private int canvasHeight;
    public String[][] pipe;
    
    public Pipe(int pipeHeight, int pipeWidth, int pipeGap, int canvasHeight){
        this.pipeHeight = pipeHeight;
        this.pipeWidth = pipeWidth;
        this.pipeGap = pipeGap;
        this.canvasHeight = canvasHeight;
        
        pipe = new String[canvasHeight - 2][pipeWidth + 2];
        
        createPipe();
    }
    
    public void createPipe(){
        for (int row = 0; row < pipeHeight; row++){
            pipe[row][0] = "|";
            for (int column = 1; column < pipeWidth + 1; column++){
                pipe[row][column] = " ";
            }
            pipe[row][pipeWidth + 1] = "|";
        }
        pipe[pipeHeight - 1][0] = "L";
        
        for (int column = 1; column < pipeWidth + 1; column++){
            pipe[pipeHeight - 1][column] = "_";
        }
        
        pipe[pipeHeight - 1][pipeWidth + 1] = "⅃";
        
        boolean spawnBarrier = (int)(Math.random() * (7) + 1) == 1;
        boolean spawnInvincibilityPowerUp = (int)(Math.random() * (10) + 1) == 1 && !spawnBarrier;
        int randomRow = (int)(Math.random() * (pipeGap) + pipeHeight);
        int randomColumn = (int)(Math.random() * (pipeWidth + 2) + 0);
        
        for (int row = pipeHeight; row < pipeHeight + pipeGap; row++){
            for (int column = 0; column < pipeWidth + 2; column++){
                if (spawnBarrier){
                    pipe[row][column] = "⌇";
                }
                
                else{
                    pipe[row][column] = " ";
                }
            }
        }
        
        if (spawnInvincibilityPowerUp){
            pipe[randomRow][randomColumn] = "✮";
        }

        pipe[pipeHeight + pipeGap][0] = "|";
        
        for (int column = 1; column < pipeWidth + 1; column++){
            pipe[pipeHeight + pipeGap][column] = "‾";
        }
        
        pipe[pipeHeight + pipeGap][pipeWidth + 1] = "|";
        
        for (int row = pipeHeight + 1 + pipeGap; row < canvasHeight - 2; row++){
            pipe[row][0] = "|";
            for (int column = 1; column < pipeWidth + 1; column++){
                pipe[row][column] = " ";
            }
            pipe[row][pipeWidth + 1] = "|";
        }
        
    }
    
    public String[][] getPipe(){
        return pipe;
    }
}
