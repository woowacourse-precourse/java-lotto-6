package lotto.constant;

public enum ExceptionMessage {
    HEADER("[ERROR] "),
    INVALID_NUMBER_EXCEPTION(HEADER.getMessage() + "숫자만 입력 가능합니다."),
    INVALID_BLANK_EXCEPTION(HEADER.getMessage() + "공백은 입력될 수 없습니다."),
    INVALID_INPUT_NUMBER_EXCEPTION(HEADER.getMessage() + "올바르지 않은 입력입니다. 구분자(,)와 숫자를 확인하세요."),
    INVALID_BONUS_NUMBER_RANGE_EXCEPTION(HEADER.getMessage() + "보너스 번호는 1~45 사이의 숫자가 입력 되어야 합니다."),
    INVALID_BONUS_NUMBER_CONTAIN_EXCEPTION(HEADER.getMessage() + "보너스 번호는 로또 번호와 중복 될 수 없습니다."),
    LACK_MONEY_EXCEPTION(HEADER.getMessage() + "금액은 1,000원 이상 투입 되어야 합니다."),
    WRONG_INPUT_MONEY_EXCEPTION(HEADER.getMessage() + "금액은 1,000원 단위로 투입 되어야 합니다."),
    LOTTO_WRONG_SIZE_EXCEPTION(HEADER.getMessage() + "로또는 6개의 숫자가 입력 되어야 합니다."),
    LOTTO_DUPLICATE_NUMBER_EXCEPTION(HEADER.getMessage() + "중복된 숫자는 입력될 수 없습니다"),
    LOTTO_WRONG_RANGE_EXCEPTION(HEADER.getMessage() + "1~45 사이의 숫자만 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
