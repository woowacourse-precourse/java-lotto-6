package consts;

import static consts.NumericConfig.LOTTO_COUNT;
import static consts.NumericConfig.LOTTO_PRICE;

public enum ErrorMessage {

    NOT_NUMERIC_VALUE("숫자 값이 아닙니다!"),
    CANNOT_DIVIDE(String.format("구매 금액은 %d로 나누어 떨어져야 합니다!", LOTTO_PRICE.number())),
    INVALID_NUMBER_COUNT(String.format("로또 숫자의 개수는 %d개여야 합니다!", LOTTO_COUNT.number())),
    DUPLICATED_NUMBER("이미 뽑은 숫자입니다!");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
