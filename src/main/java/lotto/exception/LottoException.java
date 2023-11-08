package lotto.exception;

import static lotto.exception.LottoErrorMessage.*;

public class LottoException {
    public static class LottoSizeException extends IllegalArgumentException {
        public LottoSizeException() {
            super(LOTTO_SIZE_ERROR.toString());
        }
    }

    public static class LottoNumberDuplicateException extends IllegalArgumentException {
        public LottoNumberDuplicateException() {
            super(LOTTO_NUMBER_DUPLICATE_ERROR.toString());
        }
    }

    public static class LottoNumberRangeException extends IllegalArgumentException {
        public LottoNumberRangeException() {
            super(LOTTO_NUMBER_RANGE_ERROR.toString());
        }
    }

    public static class LottoNumberFormatException extends IllegalArgumentException {
        public LottoNumberFormatException() {
            super(LOTTO_NUMBER_FORMAT_ERROR.toString());
        }
    }
}
