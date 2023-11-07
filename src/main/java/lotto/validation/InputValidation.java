package lotto.validation;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ExceptionMessages;

public class InputValidation {

    public static void validatePurchaseAmountInput(String input) {
        isExist(input);
        isDigit(input);
        isDivisibleBy1000(input);
    }

    public static void validateWinningNumbersInput(List<String> input) {

        Set<String> set = new HashSet<>();

        isNumbersExist(input);
        for (String item : input) {
            isDigit(item);
            isWithinLottoRange(item);
            isDuplicateNumber(set, item);
        }
        isValidLottoNumbersLength(input);

    }

    public static void validateBonusNumberInput(List<Integer> lotto, String input) {
        isExist(input);
        isDigit(input);
        isWithinLottoRange(input);
        isBonusNumberInWinningNumbers(lotto, input);
    }

    private static void isExist(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NONE_INPUT.getMessage());
        }
    }

    private static void isNumbersExist(List<String> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NONE_INPUT.getMessage());
        }
    }

    private static void isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.NONE_DIGIT.getMessage());
        }
    }

    private static void isDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessages.NON_MULTIPLE_OF_1000.getMessage());
        }
    }

    private static void isDuplicateNumber(Set<String> set, String input) {
        if (!set.add(input)) {
            throw new IllegalArgumentException(
                ExceptionMessages.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void isWithinLottoRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if ((inputNumber < 1) || (inputNumber > 45)) {
            throw new IllegalArgumentException(ExceptionMessages.OUT_OF_RANGE.getMessage());
        }
    }

    private static void isValidLottoNumbersLength(List<String> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException(
                ExceptionMessages.INVALID_LOTTO_NUMBERS_LENGTH.getMessage());
        }
    }

    private static void isBonusNumberInWinningNumbers(List<Integer> inputLottoNumbers,
        String inputBonusNumber) {
        if (inputLottoNumbers.contains(Integer.parseInt(inputBonusNumber))) {
            throw new IllegalArgumentException(
                ExceptionMessages.DUPLICATE_LOTTO_BONUS.getMessage());
        }
    }
}