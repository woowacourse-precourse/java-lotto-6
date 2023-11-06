package lotto.exception;

public enum ExceptionMessage {
    NOT_NUMBER("숫자를 입력하여주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return "[ERROR] " + this.message;
    }


}
