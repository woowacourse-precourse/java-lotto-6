package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.BuyingLottoController;
import lotto.controller.DrawWinningNumberController;

public class Application {
    public static void main(String[] args) {
        BuyingLottoController buyingController = new BuyingLottoController();
        DrawWinningNumberController winningController = new DrawWinningNumberController();

        buyingController.buyLotto();
        winningController.drawWinningNumber();

        Console.close();
    }
}
