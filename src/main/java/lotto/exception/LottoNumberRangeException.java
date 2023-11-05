package lotto.exception;

import lotto.dto.PurchasedLottosDto;

public class LottoNumberRangeException extends IllegalArgumentException {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static final String ERROR_MESSAGE = String.format("[ERROR] 로또 번호는 %d에서 %d 사이여야 합니다.",
            MIN_LOTTO_NUMBER,
            MAX_LOTTO_NUMBER);

    public LottoNumberRangeException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);

    }
}
