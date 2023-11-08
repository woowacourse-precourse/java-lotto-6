package lotto.controller;
import static lotto.domain.LottoAmount.priceCalculation;
import static lotto.domain.LottoAmount.purchaseAmountValidate;
import static lotto.view.OutputView.howManyLotto;

import lotto.domain.LottoAmount;

public class LottoController {
    public static int ticketCount = 0;

    public static void run(){
        userInputLottoAmount();
    }
    public static void userInputLottoAmount(){
        purchaseAmountValidate();
        ticketCount = priceCalculation();
        System.out.println(howManyLotto(ticketCount));
    }
}
