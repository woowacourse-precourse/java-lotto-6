package lotto.constants;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    IS_NOT_NUMBER("입력한 값이 숫자가 아닙니다."),
    CAN_NOT_DIVIDE("입력한 값이 1,000원 단위가 아닙니다."),
    IS_NOT_CORRECT_RANGE_OF_NUMBER("정확한 범위의 숫자를 입력하세요.(1 ~ 45)"),
    CHECK_NUMBER_OF_INPUT("쉼표(,)를 기준으로 6개의 숫자를 입력해주세요"),
    CHECK_NUMBER_OF_DUPLICATE("중복된 숫자를 확인해 주세요."),
    CHECK_NOT_CONTAIN_NUMBERS("당첨 번호에 없는 숫자를 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
