package lotto;

import lotto.dto.ResultCalculationSystem;
import lotto.view.View;

public class Application {
    static final View view = new View();
    static ResultCalculationSystem resultCalculationSystem = new ResultCalculationSystem();


    public static void main(String[] args) {
        view.pleaseEnterLottoPaymentMessage();

        view.pleaseEnterWinningNumbersMessage();

        view.pleaseEnterBonusNumberMessage();

        view.informPurchasedLottosNumbersMessage();
    }
}
