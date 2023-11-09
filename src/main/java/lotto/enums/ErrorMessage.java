package lotto.enums;

public enum ErrorMessage {
    INVALID_PAYMENT("구매 금액은 1,000 단위의 숫자로만 입력해주세요."),
    INVALID_LOTTO_NUMBER("1~45의 숫자만 입력해주세요."),
    INVALID_LOTTO_COUNT("6개의 숫자를 쉼표(,)로 구분하여 입력해주세요."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호는 서로 중복되지 않아야합니다.");

    private final String prefix = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
