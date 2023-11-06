package lotto.util.message;

public enum ErrorMessage {
    REQUEST_NOT_DUPLICATED("중복된 번호는 사용할 수 없습니다."),
    REQUEST_DELIMITER("쉼표(,)를 이용하여 번호를 구분해주세요."),
    ERROR("[ERROR] ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR.message + message;
    }
}
