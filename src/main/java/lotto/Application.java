package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.BuyingLottoController;
import lotto.controller.DrawWinningNumberController;
import lotto.controller.StatisitcsController;

public class Application {
    public static void main(String[] args) {
        StatisitcsController statisitcsController = new StatisitcsController();
        statisitcsController.playLotto();

        Console.close();
    }
}
