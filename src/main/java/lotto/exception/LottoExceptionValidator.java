package lotto.exception;

import java.util.List;

public class LottoExceptionValidator {
    protected LottoExceptionValidator() {
    }

    public void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            IllegalArgumentException exception = new LottoException(ExceptionCode.INVALID_LOTTO_SIZE);
            throw exception;
        }
    }
}
