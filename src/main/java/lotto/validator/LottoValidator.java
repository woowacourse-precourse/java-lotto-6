package lotto.validator;

import java.util.List;
import lotto.exception.ExceptionMessage;
import lotto.model.Constants;

public class LottoValidator extends Validator {
    @Override
    public void validate(String input) {
        List<String> inputNumbers = splitNumbers(input);
        inputNumbers.forEach(this::validateOnlyNumber);

        List<Integer> winningNumbers = inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
        validateCount(winningNumbers.size());
        winningNumbers.forEach(this::validateLottoRange);
    }

    private List<String> splitNumbers(String input) {
        List<String> inputNumbers = List.of(input.split(Constants.NUMBER_SEPARATOR));
        return inputNumbers.stream()
                .map(this::removeSpace)
                .toList();
    }

    private void validateCount(int size) {
        if (size != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COUNT_EXCEPTION.getMessage());
        }
    }
}
