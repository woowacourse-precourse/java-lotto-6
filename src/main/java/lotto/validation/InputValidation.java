package lotto.validation;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ExceptionMessages;

public class InputValidation {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int ONE_LOTTO_TICKET_PRIZE = 1000;

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
        if (!existCheck(input)) {
            ExceptionMessages.NONE_INPUT.throwException();
        }
    }

    private static boolean existCheck(String input) {
        return input != null && !input.isEmpty();
    }

    private static void isNumbersExist(List<String> input) {
        if (input == null || input.isEmpty()) {
            ExceptionMessages.NONE_INPUT.throwException();
        }
    }

    private static void isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessages.NONE_DIGIT.throwException();
        }
    }

    private static void isDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % ONE_LOTTO_TICKET_PRIZE != 0) {
            ExceptionMessages.NON_MULTIPLE_OF_1000.throwException();
        }
    }

    private static void isDuplicateNumber(Set<String> set, String input) {
        if (!set.add(input)) {
            ExceptionMessages.DUPLICATE_LOTTO_NUMBERS.throwException();
        }
    }

    private static void isWithinLottoRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if ((inputNumber < LOTTO_MIN_NUMBER) || (inputNumber > LOTTO_MAX_NUMBER)) {
            ExceptionMessages.OUT_OF_RANGE.throwException();
        }
    }

    private static void isValidLottoNumbersLength(List<String> input) {
        if (input.size() != LOTTO_NUMBER_COUNT) {
            ExceptionMessages.INVALID_LOTTO_NUMBERS_LENGTH.throwException();
        }
    }

    private static void isBonusNumberInWinningNumbers(List<Integer> inputLottoNumbers,
        String inputBonusNumber) {
        if (inputLottoNumbers.contains(Integer.parseInt(inputBonusNumber))) {
            ExceptionMessages.DUPLICATE_LOTTO_BONUS.throwException();
        }
    }
}