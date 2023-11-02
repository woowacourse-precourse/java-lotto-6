package lotto.validation;

public enum ErrorMessage {
    NO_MONEY("구매 금액이 부족합니다."),
    NUM_ERROR("입력값은 양의 정수로만 입력해야합니다."),
    BLANK_ERROR("당첨 번호로 공백은 입력할 수 없습니다"),
    DUPLICATED_ERROR("당첨번호는 중복될 수 없습니다."),
    RANGE_ERROR("당첨번호는 1~45 사이의 숫자여야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
