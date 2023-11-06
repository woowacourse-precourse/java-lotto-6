package lotto.util.validator;

import static lotto.util.Seperator.WINNING_NUMBERS_SEPARATOR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;

public class LottoValidator implements Validator {
    public static final int WINNING_NUMBERS_COUNT = 6;

    @Override
    public void validate(Object value) {
        validateSize((List<Integer>) value);
        validateDuplicates((List<Integer>) value);
        validateNumberRange((List<Integer>) value);
    }

    private void validateNumberRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            LottoNumberValidator.validateRange(winningNumber);
        }
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (!isValideSize(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 " + WINNING_NUMBERS_COUNT + "개가 입력되어야 합니다.");
        }
    }

    private boolean isValideSize(List<Integer> winningNumbers) {
        return winningNumbers.size() == WINNING_NUMBERS_COUNT;
    }

    private void validateDuplicates(List<Integer> winningNumbers) {
        if (hasDuplicates(winningNumbers)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> winningNumbers) {
        return new HashSet<>(winningNumbers).size() != winningNumbers.size();
    }

    @Override
    public boolean support(Class<?> clazz) {
        return Lotto.class.isAssignableFrom(clazz);
    }
}
