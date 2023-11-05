package lotto.validator;

import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoSetting;

import java.util.List;

public class DuplicationValidator implements Validator<List<Integer>> {
    @Override
    public void validate(List<Integer> inputNumbers) {
        int uniqueNumbersCount = (int) inputNumbers.stream()
                .distinct().count();

        if (uniqueNumbersCount != inputNumbers.size()) {
            throwException(ExceptionMessage.WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }
}
