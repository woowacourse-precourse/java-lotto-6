package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

import static lotto.output.Constants.BonusNumberConstants.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.output.Constants.BonusNumberConstants.ONE_LENGTH_ERROR_MESSAGE;

public class BonusNumber extends NumbersValidator {
    public static int bonusInput(Set<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        while (true) {
            try {
                return validateBonusInput(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validateBonusInput(Set<Integer> winningNumbers) {
        String input = Console.readLine();
        validateInputLength(input, ONE_LENGTH_ERROR_MESSAGE);
        int bonus = validateNumberFormat(input);
        validateNumberRange(bonus);
        validateDuplicate(bonus, winningNumbers);
        return bonus;
    }

    private static void validateInputLength(String input, String errorMessage) {
        String[] numbers = input.split(",");
        if (numbers.length != 1) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}