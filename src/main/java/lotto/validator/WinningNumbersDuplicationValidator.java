package lotto.validator;

import lotto.domain.constants.ExceptionMessage;

import java.util.List;

public class WinningNumbersDuplicationValidator implements Validator<List<Integer>> {
    @Override
    public void validate(List<Integer> inputNumbers) {
        int uniqueNumbersCount = (int) inputNumbers.stream()
                .distinct().count();

        if (uniqueNumbersCount != inputNumbers.size()) {
            throwException(ExceptionMessage.WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }
}
