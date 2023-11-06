package lotto.controller;

import static lotto.controller.UserInputMessage.*;
import static lotto.util.ThousandSeparator.addThousandsSeparator;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;
    public final String SEPARATED_LOTTO_PRICE = addThousandsSeparator(LOTTO_PRICE);


    public LottoController() {
    }

    public void start() {
        requestLottoPurchaseAmount();
    }

    public int requestLottoPurchaseAmount() {
        System.out.printf(REQUEST_LOTTO_PURCHASE_AMOUNT, SEPARATED_LOTTO_PRICE);
        String userInput = Console.readLine();


    }
}
