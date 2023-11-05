package lotto.exception;

import lotto.constant.ErrorMessageConstants;

import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.constant.LottoConstants.MAX_LOTTO_PRICE_PER_USER;

public class MarketException extends RuntimeException {
    public enum ErrorMessage {
        VALID_MONEY("로또 금액은" + LOTTO_PRICE.getValue() + " 원 입니다."),
        NOT_DIVISIBLE("거스름돈이 존재하지 않습니다. 로또 한 장 금액은 " + LOTTO_PRICE.getValue() + " 원 입니다."),
        EXCEED_MAX_LOTTO_AMOUNT("개인이 구매 가능한 로또 금액은 최대 "  + MAX_LOTTO_PRICE_PER_USER.getValue() + "원 입니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public MarketException(String message) {
        super(ErrorMessageConstants.ERROR_PREFIX.getMessage() + message);
    }
}
