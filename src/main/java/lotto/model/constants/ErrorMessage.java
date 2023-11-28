package lotto.model.constants;

public enum ErrorMessage {
    DUPLICATION("[ERROR] 값이 중복되었습니다"),
    ISNOTINTEGER("[ERROR] 숫자를 입력해주세요"),
    OUTOFRANGE("[ERROR]번호 6개를 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
