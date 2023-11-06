package lotto.controller;

import static lotto.controller.UserInputMessage.*;
import static lotto.util.ThousandSeparator.addThousandsSeparator;
import static lotto.util.WinningNumbersMaker.makeWinningNumbers;
import static lotto.validator.Validator.isBonusNumberDuplicate;
import static lotto.validator.Validator.isBonusNumberValid;
import static lotto.validator.Validator.isPurchaseAmountValid;
import static lotto.validator.Validator.isWinningNumberValid;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;
    public final String SEPARATED_LOTTO_PRICE = addThousandsSeparator(LOTTO_PRICE);

    int purchaseAmount;
    Lotto lottoWinningNumbers;
    LottoBonus lottoBonusNumber;


    public LottoController() {
    }

    public void start() {
        requestLottoPurchaseAmount();
        requestWinningNumbers();
        requestBonusNumber();


    }

    public void requestLottoPurchaseAmount() {
        System.out.printf(REQUEST_LOTTO_PURCHASE_AMOUNT, SEPARATED_LOTTO_PRICE);
        System.out.println();
        String userInput = Console.readLine();
        try {
            isPurchaseAmountValid(userInput);
            purchaseAmount = Integer.parseInt(userInput);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestLottoPurchaseAmount();
        }
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        String userInput = Console.readLine();
        try {
            isWinningNumberValid(userInput);
            lottoWinningNumbers = makeWinningNumbers(userInput);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestWinningNumbers();
        }
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String userInput = Console.readLine();
        try {
            isBonusNumberValid(userInput);
            int bonusNumber = Integer.parseInt(userInput);
            isBonusNumberDuplicate(lottoWinningNumbers.getNumbers(), bonusNumber);
            lottoBonusNumber = new LottoBonus(bonusNumber);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            requestBonusNumber();
        }
    }
}
