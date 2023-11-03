package lotto.constants;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    IS_NOT_NUMBER("입력한 값이 숫자가 아닙니다."),
    CAN_NOT_DIVIDE("입력한 값이 1,000원 단위가 아닙니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
