package lotto.exception;

public enum LottoExceptionMessage {
    MUST_BE_NUMBER("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다."),
    MUST_BE_POSITIVE_MULTIPLE("[ERROR] 로또 구입 금액은 양의 1000의 배수로 입력해야 합니다.");

    private String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
