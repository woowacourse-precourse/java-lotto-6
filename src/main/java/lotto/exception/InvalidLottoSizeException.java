package lotto.exception;

import static lotto.domain.enums.LottoConstants.LOTTO_SIZE;

public class InvalidLottoSizeException extends IllegalArgumentException {
    private static final String INVALID_LOTTO_SIZE = String.format("[ERROR] 로또의 숫자가 %d개 여야합니다.", LOTTO_SIZE);

    public InvalidLottoSizeException() {
        super(INVALID_LOTTO_SIZE);
    }
}
