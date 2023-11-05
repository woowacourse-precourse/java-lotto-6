package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isSixLength(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_INPUT_SIX);
        }

        if (isDuplicates(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_DUPLICATE);
        }

        if (islottoRange(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }
    }

    private boolean isSixLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplicates(List<Integer> numbers) {
        return numbers.size() > numbers.stream().distinct().count();
    }

    private boolean islottoRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(
                        number -> LottoConstant.LOTTO_START_NUMBER > number || LottoConstant.LOTTO_END_NUMBER < number);
    }

}
