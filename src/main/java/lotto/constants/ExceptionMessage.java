package lotto.constants;

public enum ExceptionMessage {
    LOTTO_NUMBERS_INVALID_ERROR("[ERROR] 로또 숫자는 1에서 45사이의 중복되지 않은 6개의 숫자로 이루어져야 합니다."),
    BLANK_ERROR("[ERROR] 입력 값이 비어있습니다."),
    NOT_NUMERIC_ERROR("[ERROR] 숫자만 입력해 주세요."),
    AMOUNT_NOT_THOUSAND_UNIT_ERROR("[ERROR] 구매 금액은 1,000원 단위로만 입력해 주세요."),
    AMOUNT_MAX_LIMIT_ERROR("[ERROR] 구매 금액은 최대 20억까지만 입력해 주세요."),
    WINNING_NUMBERS_FORMAT_ERROR("[ERROR] 당첨 번호는 숫자를 ','로 구분하여 6개의 숫자를 공백없이 입력해 주세요. ex)1,2,3,4,5,6"),
    WINNING_NUMBERS_RANGE_ERROR("[ERROR] 당첨 번호는 1에서 45사이의 숫자로 입력해 주세요."),
    WINNING_NUMBERS_DUPLICATE_ERROR("[ERROR] 당첨 번호는 서로 중복되지 않게 입력해 주세요."),
    BONUS_NUMBER_RANGE_ERROR("[ERROR] 당첨 번호는 1에서 45사이의 숫자로 입력해 주세요."),
    BONUS_NUMBER_DUPLICATES_WINNING_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
