package lotto.global.error;

import lotto.domain.model.LottoPrice;

public enum ErrorType {
    DIVIDABLE_1000_MESSAGE("[ERROR] 로또를 구매하는 값은 "+ LottoPrice.LOTTO_PRICE.getValue() + "원으로 나누어떨어져야 합니다.");

    private final String value;

    ErrorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
