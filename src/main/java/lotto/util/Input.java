package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.HashSet;
import static lotto.CommonMessages.*;
import static lotto.validator.InputValidator.validateBonusNumberRange;
import static lotto.validator.InputValidator.validateToInteger;


public class Input {

    public Integer getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT.getMessage());
        try {

            String input = Console.readLine();
            Integer money = InputValidator.validateToInteger(input);

            return InputValidator.validateCorrectMoney(money);
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            getPurchaseAmount();
        }
        return null;
    }

    public HashSet<Integer> getWinningNumbers() {

        System.out.println();
        System.out.println(WINNING_AMOUNT_INPUT.getMessage());
        try {
            HashSet<Integer> winningNumbers = new HashSet<>();

            String input = Console.readLine();
            String[] splitInput = input.split(",");

            for (String number : splitInput) {
                winningNumbers.add(validateToInteger(number));
            }

            InputValidator.validateWinningNumberSize(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            getWinningNumbers();
        }
        return null;
    }

    public Integer getBonusNumber() {

        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT.getMessage());

        try {

            String input = Console.readLine();
            Integer bonusNumber = InputValidator.validateToInteger(input);
            validateBonusNumberRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            getBonusNumber();
        }

        return null;
    }
}
