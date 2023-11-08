package lotto.utils.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.utils.Constants;

public class ValidatorNumber extends Validator {
    // Fields
    private final int LOTTO_NUMBER_LENGTH = Constants.LOTTO_NUMBER_LENGTH.getValue();
    private final int RANGE_MIN = Constants.RANGE_MIN.getValue();
    private final int RANGE_MAX = Constants.RANGE_MAX.getValue();
    protected Set<Integer> winningNumbers;


    // Features
    public void validateWinningNumber(String winning) {
        List<Integer> numbers = validateWinningisNumber(winning);
        validateWinningNumberLength(numbers);
        for (int number : numbers) {
            validateWinningNumberRange(number);
            winningNumbers = new HashSet<>();
            validateWinningNumberDuplicated(number);
        }

    }

    public void validateBonusNumber(String bonus) {
        int number = validateisNumber(bonus);
        validateWinningNumberRange(number);
        validateWinningNumberDuplicated(number);
    }


    // Internal Implements
    private List<Integer> validateWinningisNumber(String winning) {
        List<Integer> numbers;
        try {
            numbers = Arrays
                    .stream(winning.split(","))
                    .map(Integer::valueOf).
                    collect(Collectors.toList());
            return numbers;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberRange(int number) {
        if (number < RANGE_MIN || number > RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberDuplicated(int number) {
        if (!winningNumbers.add(number)) {
            throw new IllegalArgumentException();
        }
    }

}
