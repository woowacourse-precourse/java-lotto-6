package lotto.record;

import static lotto.enumerate.ConfigInteger.LOTTO_END_NUMBER;
import static lotto.enumerate.ConfigInteger.LOTTO_NUMBER_COUNT;
import static lotto.enumerate.ConfigInteger.LOTTO_START_NUMBER;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_OVER_OR_UNDER_SIZE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.List;

public record LottoNumbers(List<Integer> lottoNumbers) {
    public LottoNumbers {
        validate(lottoNumbers);
    }

    private void validate(List<Integer> numbers) {
        lottoNumberSizeValidate(numbers);
        LottoNumberDuplicateValidate(numbers);
        lottoNumberUnderOverValidate(numbers);
    }


    private void lottoNumberUnderOverValidate(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LOTTO_START_NUMBER.getInt() || number > LOTTO_END_NUMBER.getInt())) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void LottoNumberDuplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            exceptionCodeThrow(LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void lottoNumberSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getInt()) {
            exceptionCodeThrow(LOTTO_NUMBER_OVER_OR_UNDER_SIZE);
        }
    }
}
