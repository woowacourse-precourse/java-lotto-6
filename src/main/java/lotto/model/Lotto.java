package lotto.model;

import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_OVER_OR_UNDER_SIZE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.List;
import lotto.record.LottoNumberRecord;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoNumberRecord toRecord() {
        return new LottoNumberRecord(numbers);
    }

    public String makeLottoNumberString() {
        return numbers
                .stream().sorted()
                .toList()
                .toString();
    }

    private void validate(List<Integer> numbers) {
        lottoNumberSizeValidate(numbers);
        LottoNumberDuplicateValidate(numbers);
        lottoNumberUnderOverValidate(numbers);
    }

    private void lottoNumberUnderOverValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER)) {
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
}
