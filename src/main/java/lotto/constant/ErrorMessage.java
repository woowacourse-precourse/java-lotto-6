package lotto.constant;

public enum ErrorMessage {
    NUMBER_SIZE_ERROR("[ERROR] 로또 하나 당 6개의 숫자를 가지고 있어야합니다."),
    WINNING_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개의 숫자를 가지고 있어야합니다."),
    NUMBER_DUPLICATE_ERROR("[ERROR] 6개의 숫자는 중복된 값을 가질 수 없습니다."),
    WINNING_NUMBER_DUPLICATE_ERROR("[ERROR] 당첨번호는 중복된 값을 가질 수 없습니다."),
    RANGE_ERROR("[ERROR] " + LottoConstant.MIN_VALUE.getValue() + "에서 " + LottoConstant.MAX_VALUE.getValue()
            + " 범위의 숫자를 입력해주세요"),
    BONUS_NUMBER_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다."),
    CANNOT_DIVISIBLE_MESSAGE("[ERROR] 금액을 " + LottoConstant.LOTTO_PRICE.getValue() + "원 단위로 나눌 수 없습니다."),
    WRONG_TYPE_INPUT_MESSAGE("[ERROR] 정수형태로 입력해주세요"),
    NON_EMPTY_MESSAGE("[ERROR] 값을 입력해주세요."),
    NON_BLANK_MESSAGE("[ERROR] 비어있는 값은 입력할 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
