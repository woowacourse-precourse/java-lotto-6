package lotto.domain.lotto;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class LottoRule {
    public static final int LENGTH = 6;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;


    protected void validate(List<Integer> numbers) {
        if (isMismatchLength(numbers)) {
            ExceptionMessage.LOTTO_MISMATCH_LENGTH.throwException();
        }
        if (isDuplicate(numbers)) {
            ExceptionMessage.LOTTO_DUPLICATE.throwException();
        }
        if (isOutOfRange(numbers)) {
            ExceptionMessage.LOTTO_OUT_OF_RANGE.throwException();
        }
    }

    protected boolean isOutOfRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            return true;
        }
        return false;
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isOutOfRange(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMismatchLength(List<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            return true;
        }
        return false;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            return true;
        }
        return false;
    }

}
