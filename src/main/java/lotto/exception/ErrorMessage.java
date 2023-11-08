package lotto.exception;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoPrice;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_RANGE("로또 숫자의 범위는 %d ~ %d 까지 입니다.".formatted(
            LottoNumber.MIN_NUMBER,
            LottoNumber.MAX_NUMBER
    )),
    INVALID_LOTTO_SIZE("로또 숫자는 %d 개만 가능합니다.".formatted(Lotto.LOTTO_SIZE)),
    INVALID_LOTTO_DUPLICATES("로또 숫자는 중복될 수 없습니다."),
    INVALID_LOTTO_PRICE_NEGATIVE("로또 가격은 음수일 수 없습니다."),
    INVALID_PRIZE_NUMBER_TYPE("모두 당첨 번호 형식만 있어야 합니다."),
    INVALID_BONUS_NUMBER_TYPE("보너스 번호 형식만 있어야 합니다."),
    INVALID_PRIZE_AMOUNT_PRICE_NEGATIVE("당첨 금액은 음수일 수 없습니다."),
    INVALID_PRIZE_MATCH_COUNT_NEGATIVE("일치 번호는 음수일 수 없습니다."),
    INVALID_PURCHASING_AMOUNT_NOT_DIVIDED(
            "구입 금액은 %d 단위여야 합니다.".formatted(LottoPrice.ONE.getPrice())),
    INVALID_BONUS_NUMBER_NOT_UNIQUE("보너스 번호는 당첨 번호와 달라야 합니다."),
    INPUT_ONLY_NUMBERS("숫자만 입력이 가능합니다."),
    INVALID_TOTAL_PRIZE_AMOUNT_PRICE_NEGATIVE("총 당첨 금액은 음수일 수 없습니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String ERROR_DELIMITER = " ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + ERROR_DELIMITER + message;
    }
}
