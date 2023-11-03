package lotto;

import lotto.domain.Amount;

public enum ErrorMessage {

    AMOUNT_IS_DIVIDED_LOTTO_PRICE(Amount.dd + "로 나누어 떨어져야 함"),
    AMOUNT_IS_POSITIVE("0 이거나 음수일 수 없음"),
    INPUT_NUMBER("숫자를 입력해주세요.");

    private static final String PREFIX = "[ERROR]";
    private static final String DELIMITER = " ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return String.join(DELIMITER, PREFIX, message);
    }
}
