package lotto;

import lotto.domain.GameController;
import lotto.domain.lotto.Profit;
import lotto.domain.lotto.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.play();
    }
}
