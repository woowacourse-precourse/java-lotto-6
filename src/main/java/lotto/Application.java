package lotto;

import lotto.service.ResultCalculationService;
import lotto.view.View;

public class Application {
    static final View view = View.getInstance();

    public static void main(String[] args) {
        view.pleaseEnterLottoPaymentMessage();

        view.pleaseEnterWinningNumbersMessage();

        view.pleaseEnterBonusNumberMessage();

        view.informPurchasedLottosNumbersMessage();
    }
}
