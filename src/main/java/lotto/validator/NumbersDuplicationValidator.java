package lotto.validator;

import lotto.domain.constants.ExceptionMessage;

import java.util.List;

public class NumbersDuplicationValidator implements Validator<List<Integer>> {
    @Override
    public void validate(List<Integer> numbers) {
        int uniqueNumbersCount = (int) numbers.stream()
                .distinct().count();

        if (uniqueNumbersCount != numbers.size()) {
            throwException(ExceptionMessage.WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }
}
