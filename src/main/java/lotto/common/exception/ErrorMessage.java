package lotto.common.exception;

import lotto.common.constants.LottoRule;

public enum ErrorMessage {
    DUPLICATED_NUMBER("로또 번호는 서로 중복되지 않아야 합니다."),
    INVALID_LOTTO_NUMBERS_SIZE(String.format("로또 번호는 %d개여야 합니다.", LottoRule.LOTTO_NUMBER_SIZE.getValue())),
    INVALID_LOTTO_NUMBER_RANGE(String.format("로또 번호는 %d부터 %d사이여야 합니다.",
            LottoRule.LOTTO_NUMBER_MIN.getValue(), LottoRule.LOTTO_NUMBER_MAX.getValue()));

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValue(Object invalidArgument) {
        return this.value + ": " + invalidArgument;
    }
}
