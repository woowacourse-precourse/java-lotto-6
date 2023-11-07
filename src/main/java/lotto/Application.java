package lotto;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Start_game start_game = new Start_game();

        start_game.run();


    	
    }
}

enum Prize {
    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000), NONE(0);
    public int prize;
    Prize(int prize) {
        this.prize = prize;
    }
}