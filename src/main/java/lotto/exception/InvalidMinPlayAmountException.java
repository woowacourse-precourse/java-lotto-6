package lotto.exception;

import static lotto.domain.enums.LottoConstants.MIN_PLAYER_AMOUNT;

public class InvalidMinPlayAmountException extends IllegalArgumentException {
    private static final String INVALID_PLAYER_AMOUNT = String.format("[ERROR] 구매금액이 %d원 이상이어야 합니다.",
            MIN_PLAYER_AMOUNT);

    public InvalidMinPlayAmountException() {
        super(INVALID_PLAYER_AMOUNT);
    }
}
