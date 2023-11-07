package lotto.constant;

public enum ErrorMessage {
    NUMBER_SIZE_ERROR("[ERROR] 로또 하나 당 6개의 숫자를 가지고 있어야합니다."),
    WINNING_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개의 숫자를 가지고 있어야합니다."),
    NUMBER_DUPLICATE_ERROR("[ERROR] 6개의 숫자는 중복된 값을 가질 수 없습니다."),
    WINNING_NUMBER_DUPLICATE_ERROR("[ERROR] 당첨번호는 중복된 값을 가질 수 없습니다."),
    RANGE_ERROR("[ERROR] 1에서 45 범위의 숫자를 입력해주세요");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
