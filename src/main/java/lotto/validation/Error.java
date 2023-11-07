package lotto.validation;

public enum Error {
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    Input_FORMAT_ERROR("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_ERROR("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    LOTTO_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다."),
    NOT_INTEGER_ERROR("[ERROR] 숫자를 입력해 주세요."),
    PURCHASE_AMOUNT_RANGE_ERROR("[ERROR] 로또 구입 금액은 1000원 이상 100000원 이하로 입력해주세요."),
    WINNING_NUMBER_DUPLICATE_ERROR("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
