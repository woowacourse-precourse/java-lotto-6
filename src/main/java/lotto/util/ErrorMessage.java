package lotto.util;

public enum ErrorMessage {

    INPUT_STRING_ERROR("[ERROR] 입력된 정보는 정수가 아닌 문자열 입니다."),
    INPUT_MULTIPLES_OF_1000_ERROR("[ERROR] 입력된 정수는 1000의 배수가 아닙니다."),
    INPUT_WINNING_NUMBER_ERROR("[ERROR] 6개의 당첨 번호를 입력해야 합니다."),
    WINNING_NUMBER_RANGE_ERROR("[ERROR] 로또 숫자는 1 이상 45 이하여야 합니다.");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
