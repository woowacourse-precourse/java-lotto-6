package lotto.global.error;

import lotto.domain.model.LottoPrice;

public enum ErrorType {
    NOT_DIVIDED_BY_MESSAGE("[ERROR] 로또를 구매하는 값은 "+ LottoPrice.LOTTO_PRICE.getValue() + "원으로 나누어떨어져야 합니다."),
    WRONG_LOTTO_COUNT_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE_NUMBER_MESSAGE("[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다.");

    private final String value;

    ErrorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
