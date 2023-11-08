package lotto;

import static lotto.Enum.ErrorMessage.DUPLICATED_ERROR;
import static lotto.Enum.ErrorMessage.NOT_NUMBER_ERROR;
import static lotto.Enum.ErrorMessage.NUMBER_NOT_IN_RANGE_ERROR;
import static lotto.Enum.ErrorMessage.NUMBER_NOT_DIVIDE_BY_THOUSAND_ERROR;
import static lotto.Enum.Number.MAX_LOTTO_NUMBER;
import static lotto.Enum.Number.MIN_LOTTO_NUMBER;
import static lotto.Enum.Number.THOUSAND;

import java.util.ArrayList;
import java.util.List;

public class Exception {
    public static void checkIfNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkUnit(int money) {
        if (money % THOUSAND.getNumber() != 0) {
            throw new IllegalArgumentException(NUMBER_NOT_DIVIDE_BY_THOUSAND_ERROR.getMessage());
        }
    }

    private static void checkIfBonusNumberDuplicatedWithLottoNumbers(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
        }
    }

    private static void validateInputStartAndEndWithNumber(String input){
        checkIfNumber(String.valueOf(input.charAt(input.length() - 1)));
        checkIfNumber(String.valueOf(input.charAt(0)));
    }

    public static List<Integer> validateWinningNumbers(String input) {
        validateInputStartAndEndWithNumber(input);
        String[] splitInput = input.split(",");
        List<Integer> validatedNumbers = new ArrayList<>();
        for (String s : splitInput) {
            checkIfNumber(s);
            validatedNumbers.add(Integer.parseInt(s));
        }
        Lotto.validateLottoNumbersLength(validatedNumbers);
        Lotto.validateLottoNumbersNotDuplicated(validatedNumbers);
        return validatedNumbers;
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String input) {
        checkIfNumber(input);
        int result = Integer.parseInt(input);
        checkIfNumberInRange(result);
        checkIfBonusNumberDuplicatedWithLottoNumbers(winningNumbers, result);
    }

    private static void checkIfNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER.getNumber() || number > MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE_ERROR.getMessage());
        }
    }
}
