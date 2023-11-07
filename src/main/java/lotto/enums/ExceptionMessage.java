package lotto.enums;

public enum ExceptionMessage {
    CONTAIN_NON_DIGIT_EXCEPTION("[ERROR] 숫자만 입력할 수 있습니다."),
    NOT_DIVIDING_BY_LOTTO_PRICE_EXCEPTION("[ERROR] 금액은 1,000원 단위로 입력할 수 있습니다."),
    NOT_SIX_DIGITS_SEPARATED_BY_COMMAS_EXCEPTION("[ERROR] 쉼표(,)로 구분된 숫자 6개를 입력하세요."),
    INPUT_DUPLICATE_DIGIT_EXCEPTION("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    INPUT_WRONG_RANGE_EXCEPTION("[ERROR] 1에서 45사이의 숫자만 입력할 수 있습니다."),
    WINNING_NUMBERS_CONTAIN_BONUS_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    NOT_SIX_NUMBERS_EXCEPTION("[ERROR] 발행된 로또 번호의 개수는 6개여야 합니다."),
    CONTAIN_DUPLICATE_DIGITS_EXCEPTION("[ERROR] 발행된 로또는 중복된 숫자를 포함할 수 없습니다."),
    NUMBERS_WRONG_RANGE_EXCEPTION("[ERROR] 발행된 로또의 번호는 1에서 45사이 여야 합니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
