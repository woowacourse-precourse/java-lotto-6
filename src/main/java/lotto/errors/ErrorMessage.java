package lotto.errors;

public enum ErrorMessage implements MainErrorMessage {

    WRONG_NUMBER_FORMAT("정수인 숫자를 입력해야 합니다."),
    NOT_SMALLER_THAN_ZERO("0보다 큰 값을 입력해야 합니다."),
    WRONG_COST("1000의 배수를 입력해야 합니다."),
    WRONG_LUCKY_NUMBER_FORMAT("','로 구분되는 6개의 정수인 숫자를 입력해야 합니다."),
    WRONG_LUCKY_NUMBER_COUNT("입력된 숫자의 개수가 6개이어야 합니다."),
    NO_DUPLICATED_NUMBER("중복된 숫자를 입력할 수 없습니다."),
    WRONG_NUMBER_RANGE("1부터 45사이의 숫자를 입력해야 합니다."),
    WRONG_BONUS_NUMBER("당첨번호와 중복된 숫자를 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = START_ERROR_MESSAGE + message + END_ERROR_MESSAGE;
    }

    public String getMessage() {
        return message;
    }
}
