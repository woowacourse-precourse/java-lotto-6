package lotto;

import lotto.adapter.ConsoleInputAdapter;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new ConsoleInputAdapter());
        lottoGameController.playGame();
    }
}
