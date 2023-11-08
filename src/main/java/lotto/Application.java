package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.start();
        Console.close();
    }
}
