package lotto.controller;

import lotto.domain.LottoMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {
        LottoMoney lottoMoney = getLottoMoney();
    }

    public static LottoMoney getLottoMoney() {
        try {
            OutputView.printLottoPurchaseMoneyMessage();
            String input = InputView.readLine();
            OutputView.printEmptyLine();
            return new LottoMoney(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return getLottoMoney();
        }
    }
}
