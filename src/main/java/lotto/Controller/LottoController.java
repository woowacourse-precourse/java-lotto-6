package lotto.controller;

import static lotto.controller.UserInputMessage.*;
import static lotto.util.ThousandSeparator.addThousandsSeparator;
import static lotto.util.WinningNumbersMaker.makeWinningNumbers;
import static lotto.validator.Validator.isPurchaseAmountValid;
import static lotto.validator.Validator.isWinningNumberValid;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;
    public final String SEPARATED_LOTTO_PRICE = addThousandsSeparator(LOTTO_PRICE);


    public LottoController() {
    }

    public void start() {
        int purchaseAmount = requestLottoPurchaseAmount();
        Lotto winningNumbers = requestWinningNumbers();
    }

    public int requestLottoPurchaseAmount() {
        try {
            System.out.printf(REQUEST_LOTTO_PURCHASE_AMOUNT, SEPARATED_LOTTO_PRICE);
            System.out.println();
            String userInput = Console.readLine();
            isPurchaseAmountValid(userInput);
            return Integer.parseInt(userInput);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return requestLottoPurchaseAmount();
        }
    }

    public Lotto requestWinningNumbers() {
        try {
            System.out.println(REQUEST_WINNING_NUMBERS);
            String userInput = Console.readLine();
            isWinningNumberValid(userInput);
            return makeWinningNumbers(userInput);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return requestWinningNumbers();
        }
    }

    public LottoBonus requestBonusNumber() {
        try{
            System.out.println(REQUEST_BONUS_NUMBER);
            String userInput = Console.readLine();

        }
    }
}
