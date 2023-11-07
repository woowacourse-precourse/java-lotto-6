package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;

public class UserInput {

    public static int getUserMoney() {
        String input;

        while (true) {
            try {
                input = readLine();
                validateUserMoney(input);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        String input;
        List<String> inputs;

        while (true) {
            try {
                input = readLine().replace(" ", "");
                inputs = Arrays.asList(input.split(","));
                validateWinningNumbers(inputs);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        List<Integer> winningNumbers = new ArrayList<>(inputs.stream().map(Integer::parseInt).toList());
        return winningNumbers;
    }

    public static int getBonusNumber(Lotto winningLotto) {
        String input;
        while (true) {
            try {
                input = readLine();
                validateBonusNumber(input, winningLotto);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    private static void validateUserMoney(String input) {
        validateNotNumber(input);
        validateMoneyRange(Integer.parseInt(input));
    }

    private static void validateWinningNumbers(List<String> inputs) {
        validateWinningNumbersNotSixDigits(inputs);

        for (String input : inputs) {
            validateNotNumber(input);
        }

        List<Integer> winningNumbers = inputs.stream().map(Integer::parseInt)
                .filter(integer -> integer >= 1 && integer <= 45).toList();

        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbersNotSame(winningNumbers);
    }

    private static void validateBonusNumber(String input, Lotto winningLotto) {
        if (Arrays.asList(input.split(",")).size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_BONUS_NOT_ONE_DIGIT.getMessage());
        }

        validateNotNumber(input);
        validateBonusNumberRange(Integer.parseInt(input));
        validateWinningNumbersContainBonusNumber(winningLotto, Integer.parseInt(input));
    }

    private static void validateNotNumber(String input) {
        if (!isNumberInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_NOT_NUMBER.getMessage());
        }
    }

    private static void validateMoneyRange(int input) {
        if (!isNumberOverThanPrice(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_MONEY_UNDER_1K.getMessage());
        }
        if (!isNumberMultipleOfPrice(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_MONEY_NOT_MULTIPLES.getMessage());
        }
    }

    private static void validateWinningNumbersNotSixDigits(List<String> inputs) {
        if (inputs.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_WINNIG_NUMBER_NOT_SIX_DIGITS.getMessage());
        }
    }

    private static void validateWinningNumbersRange(List<Integer> inputs) {
        if (inputs.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_WINNIG_NUMBER_OVER_RANGE.getMessage());
        }
    }

    private static void validateWinningNumbersNotSame(List<Integer> inputs) {
        if (new HashSet<>(inputs).size() != inputs.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_WINNIG_NUMBER_SAME_NUMBER.getMessage());
        }
    }

    private static void validateBonusNumberRange(int input) {
        if (!isNumberInCorrectRange(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_BONUS_NUMBER_OVER_RANGE.getMessage());
        }
    }

    private static void validateWinningNumbersContainBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (isWinningNumbersContainBonusNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OF_BONUS_NOT_CONTAIN_WINNING_NUMBERS.getMessage());

        }
    }

    private static boolean isNumberInteger(String input) {
        String regularExpression = "^[0-9]+$";
        return input.matches(regularExpression);
    }

    private static boolean isNumberOverThanPrice(int input) {
        return input >= Lotto.getPrice();
    }

    private static boolean isNumberMultipleOfPrice(int input) {
        return input % Lotto.getPrice() == 0;
    }

    private static boolean isNumberInCorrectRange(int input) {
        return (input > 0 && input < 46);
    }

    private static boolean isWinningNumbersContainBonusNumber(Lotto winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }
}
