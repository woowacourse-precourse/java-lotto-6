package lotto;

import lotto.service.ResultCalculationService;
import lotto.view.View;

public class Application {
    static final View view = new View();
    static ResultCalculationService resultCalculationService = new ResultCalculationService();


    public static void main(String[] args) {
        view.pleaseEnterLottoPaymentMessage();

        view.pleaseEnterWinningNumbersMessage();

        view.pleaseEnterBonusNumberMessage();

        view.informPurchasedLottosNumbersMessage();
    }
}
