package lotto;

public enum ErrorMessages {
    CAN_NOT_CONVERT_TO_NUMBER("숫자를 입력하지 않았습니다."),
    NOT_A_MULTIPLE_OF_1000("1000의 배수를 입력하지 않았습니다."),
    NOT_SIX_NUMBERS("6개의 숫자를 입력해야합니다.");


    private String message;

    ErrorMessages(String s) {
    }

    public String getMessage() {
        return "[ERROR] "+message;
    }
}
