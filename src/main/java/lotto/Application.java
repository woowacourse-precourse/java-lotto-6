package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.BuyingLottoController;
import lotto.controller.WinningNumberController;

public class Application {
    public static void main(String[] args) {
        BuyingLottoController buyingController = new BuyingLottoController();
        WinningNumberController winningController = new WinningNumberController();

        buyingController.buyLotto();
        winningController.drawWinningNumber();

        Console.close();
    }
}
