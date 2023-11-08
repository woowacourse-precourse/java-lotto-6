package lotto.view;

import static lotto.validator.InputValidator.*;
import static lotto.view.constants.PrintType.*;

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

    public static int inputBonusNumber(Lotto lotto) {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE.getMessage());
        return judgeReEnterBonusNumberValue(lotto);
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

    private static int judgeReEnterBonusNumberValue(Lotto lotto) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = validateBonusNumber(lotto, Console.readLine());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        Console.close();
        return bonusNumber;
    }
}
