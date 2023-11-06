package lotto.validator.constants;

public enum ExceptionMessage {
    BLANK_ERROR("[ERROR] 빈 값은 입력할 수 없습니다."),
    NOT_NUMERIC_ERROR("[ERROR] 숫자인 값만 입력 가능합니다."),
    PAY_AMOUNT_DIGIT_EROOR("[ERROR] 구매금액은 최대 10자리의 수만 입력 가능합니다."),
    PAY_AMOUNT_ONE_THOUSAND_UNIT_ERROR("[ERROR] 구매는 1000원 단위로만 가능합니다."),
    PAY_AMOUNT_RANGE_ERROR("[ERROR] 최대 20억까지만 구매 가능합니다."),
    WINNING_NUMBERS_PATTERN_ERROR("[ERROR] 당첨번호는 숫자를 ,로 구분하여 입력해 주세요. ex)1,2,3,4,5,6"),
    WINNING_NUMBERS_RANGE_ERROR("[ERROR] 당첨번호는 1에서 45사이의 숫자로 입력해 주세요."),
    WINNING_NUMBERS_DUPLICATE_ERROR("[ERROR] 당첨번호는 중복되지 않는 숫자들로 입력해 주세요."),
    LOTTO_ERROR("[ERROR] 로또 숫자는 1에서 45사이의 중복되지 않은 6개의 숫자로 이루어져야 합니다."),
    BONUS_NUMBER_DUPLICATES_WINNING_NUMBER_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
