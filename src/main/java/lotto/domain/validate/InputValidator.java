package lotto.domain.validate;

import lotto.domain.validate.exception.InputException;

import java.util.List;

public class InputValidator {
    public void validatePurchaseAmount(String input) {
        int intInput = parseInt(input);

        isInMoneyRange(intInput);
        isDivided(intInput);
    }

    public void validateWinningNumber(String input) {
        List<String> stringNumbers = splitInput(input);
        List<Integer> integerNumbers = stringNumbers.stream().map(this::parseInt).toList();
        isDistinctNumbers(integerNumbers);
        integerNumbers.forEach(this::isInLottoNumberRange);
    }

    public void validateBonusNumber(String input, List<Integer> lottoNumbers) {
        int intInput = parseInt(input);
        isInLottoNumberRange(intInput);

        if (lottoNumbers.contains(intInput)) {
            throw new IllegalArgumentException(InputException.NOT_DISTINCT_BONUS_NUMBER.getMessage());
        }
    }

    private int parseInt(String input) {
        int intInput;

        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.NO_NUMBER.getMessage());
        }

        return intInput;
    }

    private void isDivided(int intInput) {
        if ((intInput % 1000) != 0) {
            throw new IllegalArgumentException(InputException.NOT_DIVIDED_BY_1000.getMessage());
        }
    }

    private void isInMoneyRange(int intInput) {
        if (intInput < 1000 || intInput >= 100000) {
            throw new IllegalArgumentException(InputException.NOT_IN_RANGE_MONEY.getMessage());
        }
    }

    private void isDistinctNumbers(List<Integer> integers) {
        int numbersLength = integers.stream().distinct().toList().size();
        if (numbersLength != 6) {
            throw new IllegalArgumentException(InputException.NOT_DISTINCTNESS.getMessage());
        }
    }

    private List<String> splitInput(String input) {
        return List.of(input.split(","));
    }

    private void isInLottoNumberRange(Integer number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException(InputException.NOT_IN_RANGE_LOTTO_NUMBER.getMessage());
        }
    }
}
