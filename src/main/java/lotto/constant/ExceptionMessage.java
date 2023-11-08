package lotto.constant;

public enum ExceptionMessage {
    LOTTO_SIZE_ERROR_MESSAGE("[ERROR] 현재 로또가 6개의 숫자를 포함하고 있지 않습니다."),
    LOTTO_DUPLICATION_NUMBER_ERROR_MESSAGE("[ERROR] 로또에 중복된 숫자가 포함되어 있습니다."),
    LOTTO_NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 포함되어야 합니다."),
    INPUT_MONEY_ERROR_MESSAGE("[ERROR] 금액을 0원 이상 입력해주세요."),
    INPUT_MONEY_UNIT_ERROR_MESSAGE("[ERROR] 금액을 1000원 단위로 입력해주세요."),
    INPUT_BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE("[ERROR] 당첨번호에 포함된 숫자입니다. 다시 입력해주세요."),
    INPUT_BOUNUS_NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 1부터 45 이내의 숫자만 입력해주세요."),
    INPUT_TYPE_ERROR_MESSAGE("[ERROR] 숫자를 입력해주세요."),
    INPUT_ERROR_SPACE_MESSAGE("[ERROR] 공백을 제외하고 입력해주세요."),
    INPUT_ERROR_MESSAGE("[ERROR] 잘못된 입력방식입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
