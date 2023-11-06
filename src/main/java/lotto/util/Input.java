package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.HashSet;
import static lotto.CommonMessages.*;
import static lotto.validator.InputValidator.*;
import static lotto.validator.InputValidator.validateBonusNumberRange;
import static lotto.validator.InputValidator.validateToInteger;


public class Input {

    public Integer getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT.getMessage());
        try {

            String input = Console.readLine();
            Integer money = validateToInteger(input);

            return validateCorrectMoney(money);
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
            String[] inputNumbers = input.split(",");

            addWinningNumber(winningNumbers, inputNumbers);

            validateWinningNumberSize(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            getWinningNumbers();
        }
        return null;
    }

    private static void addWinningNumber(HashSet<Integer> winningNumbers, String[] inputNumbers) {
        for (String number : inputNumbers) {
            winningNumbers.add(validateToInteger(number));
        }
    }

    public Integer getBonusNumber() {

        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT.getMessage());

        try {

            String input = Console.readLine();
            Integer bonusNumber = validateToInteger(input);
            validateBonusNumberRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            getBonusNumber();
        }

        return null;
    }
}
