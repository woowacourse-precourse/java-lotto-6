package lotto.controller;

import static lotto.controller.UserInputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public LottoController() {
    }

    public void start() {

    }

    public void requestLottoPurchaseAmount() {
        System.out.printf(REQUEST_LOTTO_PURCHASE_AMOUNT, LOTTO_PRICE);

    }
}
