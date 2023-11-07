package lotto.message;

public enum ErrorMessage {
    NOT_NUMERIC_EXCEPTION("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다."),
    MULTIPLE_OF_THOUSAND_EXCEPTION("[ERROR] 로또 구입 금액은 1000원 단위로 입력 가능합니다."),
    THOUSAND_OR_MORE_EXCEPTION("[ERROR] 로또 구입 금액은 1000원 이상만 입력 가능합니다.");


    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
