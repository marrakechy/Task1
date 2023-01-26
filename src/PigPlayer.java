import java.util.Scanner;

public class PigPlayer {
    private int score;
    private String name;
    private int turnTotal;
    private Die d;
    private int lastRoll;

    public PigPlayer(String name) {
        this.name = name;
        d = new Die();
        turnTotal = 0;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void takeTurn (){

        boolean rolling = true;
        Scanner scan = new Scanner(System.in);
        System.out.print(name+"'s turn");
        lastRoll = d.roll();

        while (lastRoll != 1 && rolling){
            turnTotal += lastRoll;
            printTurnStats();
            System.out.println("Roll Again (y/n)");
            rolling = scan.next().equals("y");
            if(rolling){
                lastRoll = d.roll();
            }
        }
        if (lastRoll == 1){
            turnTotal = 0;
            System.out.print("\t Rolled 0; no points");
        }
        score += turnTotal;
    }

    private void printTurnStats(){
        System.out.print("\t Last Roll: + "+lastRoll);
        System.out.print("\t Turn Total: "+ turnTotal);
        System.out.println("\t Score: "+ (score + turnTotal));
    }
}

class PigGame {
    private PigPlayer player1;
    private PigPlayer player2;
    private boolean gameOver;

    public PigGame() {
        player1 = new PigPlayer("Player 1");
        player2 = new PigPlayer("Player 2");
        gameOver = false;
    }

    public void play() {
        while (!gameOver) {
            player1.takeTurn();
            if (player1.getScore() >= 100) {
                gameOver = true;
                break;
            }
            player2.takeTurn();
            if (player2.getScore() >= 100) {
                System.out.println("Player 2 wins!");
                gameOver = true;
                break;
            }
        }
    }
}
