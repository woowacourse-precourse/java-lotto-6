package lotto.model;

import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_OVER_OR_UNDER_SIZE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoNumberSizeValidate(numbers);
        LottoNumberDuplicateValidate(numbers);
        lottoNumberUnderOverValidate(numbers);
    }

    private void lottoNumberUnderOverValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void LottoNumberDuplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            exceptionCodeThrow(LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void lottoNumberSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exceptionCodeThrow(LOTTO_NUMBER_OVER_OR_UNDER_SIZE);
        }
    }

    // TODO: 추가 기능 구현
}
