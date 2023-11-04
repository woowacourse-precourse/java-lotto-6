package lotto.controller;

import static lotto.view.InputView.requestLotteryNumber;
import static lotto.view.InputView.requestPurchaseAmount;
import static lotto.view.OutputView.responseCount;

import lotto.domain.PurchaseAmount;

public class LottoController {

    public static void start(){

        PurchaseAmount.creat(requestPurchaseAmount());
        responseCount(PurchaseAmount.count);
        requestLotteryNumber();

    }
}