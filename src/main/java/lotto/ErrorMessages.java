package lotto;

public enum ErrorMessages {
    CAN_NOT_CONVERT_TO_NUMBER("숫자를 입력하지 않았습니다."),
    NOT_A_MULTIPLE_OF_1000("1000의 배수를 입력하지 않았습니다."),
    NOT_SIX_NUMBERS("6개의 숫자를 입력해야합니다."),
    FALL_OUTSIDE_THE_RIGHT_RANGE("1 ~ 45 사이의 숫자를 입력해야합니다."),
    THERE_ARE_DUPLICATE_VALUES("중복된 값을 입력하면 안됩니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] "+ message;
    }
}
