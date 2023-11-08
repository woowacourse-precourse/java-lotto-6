package lotto;

import lotto.controller.GameController;
import lotto.domain.NumbersGeneratorStrategy;
import lotto.domain.RandomNumbersGeneratorStrategy;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        NumbersGeneratorStrategy numbersGeneratorStrategy = new RandomNumbersGeneratorStrategy();
        gameController.play(numbersGeneratorStrategy);
    }
}
