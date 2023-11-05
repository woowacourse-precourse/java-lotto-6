package lotto.controller;

import static lotto.domain.Lotto.randomNumber;
import static lotto.view.InputView.requestLotteryNumber;
import static lotto.view.InputView.requestPurchaseAmount;
import static lotto.view.OutputView.responseCount;
import static lotto.view.OutputView.responseLottoNumber;

import lotto.domain.PurchaseAmount;

public class LottoController {

    private static int count;

    public static void start() {
        PurchaseAmount.creat(requestPurchaseAmount());

        count = PurchaseAmount.count;
        responseCount(count);
        randomNuber(count);
    }

    public static void randomNuber(int count) {
        randomNumber(count);
        responseLottoNumber(count);
    }

    public static void lotteryNumber() {
        requestLotteryNumber();
    }
}