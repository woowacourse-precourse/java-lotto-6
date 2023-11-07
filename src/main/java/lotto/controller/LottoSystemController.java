package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoSystem;

import static lotto.controller.InputController.inputMoney;
import static lotto.view.OutputView.*;

public class LottoSystemController {

    public static void startLottoSystem() {
        LottoSystem lottoSystem = new LottoSystem(inputMoney());

        printBuyLotto(lottoSystem);
    }

    private static void printBuyLotto(LottoSystem lottoSystem) {
        printLottoCnt(lottoSystem.getPurchaseLottoCount());

        for (Lotto lotto : lottoSystem.getPurchaseLottos()) {
            printLottoNumbers(lotto);
        }
    }

}
