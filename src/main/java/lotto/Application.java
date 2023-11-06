package lotto;

import lotto.controller.BuyingController;
import lotto.controller.LottoNumberAddController;
import lotto.controller.WinningBonusNumberController;
import lotto.controller.WinningNumberController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyingController buyingController = new BuyingController();
        buyingController.handle();

        LottoNumberAddController lottoNumberAddController = new LottoNumberAddController();
        lottoNumberAddController.handle();

        WinningNumberController winningNumberController = new WinningNumberController();
        winningNumberController.handle();

        WinningBonusNumberController winningBonusNumberController = new WinningBonusNumberController();
        winningBonusNumberController.handle();
    }
}
