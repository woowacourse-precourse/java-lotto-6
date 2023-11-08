package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.run();
        Console.close();
    }
}
