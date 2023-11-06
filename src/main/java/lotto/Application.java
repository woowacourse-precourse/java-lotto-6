package lotto;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Start_game start_game = new Start_game();

        start_game.run();


    	
    }
}

enum Prize {
    FIRST, SECOND, THIRD, FOURTH, FIFTH
}