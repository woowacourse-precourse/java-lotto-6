package lotto.constant;

public enum ExceptionMessage {

    NOT_NUMBER_MESSAGE("[ERROR] 숫자가 아닌 문자가 들어 있습니다. 숫자를 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
