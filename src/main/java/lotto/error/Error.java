package lotto.error;

public enum Error {
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다."),
    LOTTO_PURCHASE_AMOUNT_ERROR("[ERROR] 구입 금액은 숫자여야 합니다."),
    LOTTO_PURCHASE_AMOUNT_UNIT_ERROR("[ERROR] 구입 금액은 1000원 단위여야 합니다."),

    WINNING_NUMBER_DUPLICATE_ERROR("[ERROR] 당첨 번호는 중복일 수 없습니다."),
    WINNING_NUMBER_INPUT_INTEGER_ERROR("[ERROR] 당첨 번호는 숫자여야 합니다."),
    WINNING_NUMBER_RANGE_ERROR("[ERROR] 당첨 번호는 1부터 45사이의 숫자여야 합니다."),
    WINNING_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야 합니다."),

    BONUS_INPUT_INTEGER_ERROR("[ERROR] 보너스 번호는 숫자여야 합니다."),
    BONUS_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다."),
    BONUS_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
