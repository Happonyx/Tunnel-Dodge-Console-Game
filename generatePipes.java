public class generatePipes implements Runnable{
    private Game game;
    private int timeBetweenPipes;
    
    public generatePipes(Game game, int timeBetweenPipes){
        this.game = game;
        this.timeBetweenPipes = timeBetweenPipes;
    }
    
    public int getTimeBetweenPipes(){
        return timeBetweenPipes;
    }
    
    public void setTimeBetweenPipes(int timeBetweenPipes){
        this.timeBetweenPipes = timeBetweenPipes;
    }
    
    public void run(){
        while (!game.playerDied() && !game.shipHitPipe()){
            try{
                game.generatePipe();
                Thread.sleep(timeBetweenPipes);
            }
            catch(InterruptedException e){
            }
        }
    }
}
