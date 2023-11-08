package lotto.exception;

import lotto.validator.LottoNumberValidator;
import lotto.validator.PriceValidator;

public enum ErrorMessage {
    NOT_NUMBER_MESSAGE("숫자만 입력 가능합니다."),
    NOT_THOUSAND_MESSAGE(String.format("%d 배수만 입력 가능합니다.", PriceValidator.PURCHASE_COST)),
    PRICE_OUT_OF_RANGE_MESSAGE(String.format("최소 주문 금액 : %,d / 최대 주문 금액 : %,d", PriceValidator.PURCHASE_COST,
            PriceValidator.MAX_PURCHASE_COST)),
    DUPLICATE_NUMBER_MESSAGE("중복 숫자는 허용되지 않습니다."),
    INVALID_NUMBER_COUNT(String.format("숫자 %d개를 입력해 주세요.", LottoNumberValidator.LOTTO_NUMBER_COUNT)),
    LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE(String.format("%d~%d 사이의 숫자만 입력 가능합니다.", LottoNumberValidator.MIN_LOTTO_NUMBER,
            LottoNumberValidator.MAX_LOTTO_NUMBER));
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
