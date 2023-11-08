package lotto.common;

public enum ErrorMessage {

    INPUT_TYPE_STRING_ERROR("[ERROR] 정수를 입력해 주세요."),
    INPUT_MULTIPLES_ERROR("[ERROR] 1000의 배수로 입력되어야 합니다."),
    INPUT_WINNING_NUMBER_LENGTH_ERROR("[ERROR] 6개의 당첨번호를 입력해 주세요."),
    NUMBER_SIZE_ERROR("[ERROR] 6개의 숫자를 입력해 주세요."),
    Duplicated_Number_ERROR("[ERROR] 6개의 숫자를 입력해 주세요.");

    private String message;
    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
