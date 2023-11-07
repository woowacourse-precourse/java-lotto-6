package lotto.controller;

import static lotto.message.ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void startGame() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();
    }

    private static PurchaseMoney getPurchaseMoney() {
        try {
            return PurchaseMoney.of(InputView.getPurchaseMoney());
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());

            return getPurchaseMoney();
        }
    }

}
