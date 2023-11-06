package lotto.exception;

public enum LottoExceptionMessage {
    MUST_BE_NUMBER("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다.");

    private String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
