package lotto;


import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.Input;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.playGame();
        Console.close();
    }
}
