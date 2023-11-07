package lotto.view;

import static lotto.validator.InputValidator.validateAmount;
import static lotto.validator.InputValidator.validatePrizeNumbers;
import static lotto.view.constants.PrintType.REQUEST_PRIZE_NUMBERS_MESSAGE;
import static lotto.view.constants.PrintType.REQUEST_PURCHASE_AMOUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class ConsoleInput {

    public static int inputAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return judgeReEnterAmountValue();
    }

    public static Lotto inputPrizeNumbers() {
        System.out.println(REQUEST_PRIZE_NUMBERS_MESSAGE.getMessage());
        return judgeReEnterPrizeNumbersValue();
    }

    private static int judgeReEnterAmountValue() {
        int amount;
        while (true) {
            try {
                amount = validateAmount(Console.readLine());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return amount;
    }

    private static Lotto judgeReEnterPrizeNumbersValue() {
        Lotto prizeNumbers;
        while (true) {
            try {
                prizeNumbers = validatePrizeNumbers(Console.readLine());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return prizeNumbers;
    }
}
