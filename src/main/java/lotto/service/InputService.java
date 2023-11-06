package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import static lotto.CommonMessages.*;
import static lotto.validator.InputValidator.*;
import static lotto.validator.InputValidator.validateToInteger;


public class InputService {

    private final OutputService outputService = new OutputService();

    public Integer getPurchaseAmount() {

        System.out.println(PURCHASE_AMOUNT_INPUT.getMessage());

        try {

            String input = Console.readLine();
            Integer money = validateToInteger(input);
            return validateCorrectMoney(money);
        } catch (IllegalArgumentException e) {

            outputService.printError(e);
            return getPurchaseAmount();
        }
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
            validateWinningNumberRange(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {

            outputService.printError(e);
            return getWinningNumbers();
        }
    }

    private static void addWinningNumber(HashSet<Integer> winningNumbers, String[] inputNumbers) {
        for (String number : inputNumbers) {
            winningNumbers.add(validateToInteger(number.trim()));
        }
    }

    public Integer getBonusNumber(HashSet<Integer> winningNumbers) {

        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT.getMessage());

        try {

            String input = Console.readLine();
            Integer bonusNumber = validateToInteger(input);
            validateNumberRange(bonusNumber);
            validateDuplicateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {

            outputService.printError(e);
            return getBonusNumber(winningNumbers);
        }
    }
}
