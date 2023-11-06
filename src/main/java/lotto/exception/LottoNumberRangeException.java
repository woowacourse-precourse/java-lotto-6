package lotto.exception;

import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import lotto.dto.PurchasedLottosDto;

public class LottoNumberRangeException extends IllegalArgumentException {



    public static final String ERROR_MESSAGE = String.format("[ERROR] 로또 번호는 %d에서 %d 사이여야 합니다.",
            MIN_LOTTO_NUMBER,
            MAX_LOTTO_NUMBER);

    public LottoNumberRangeException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);

    }
}
