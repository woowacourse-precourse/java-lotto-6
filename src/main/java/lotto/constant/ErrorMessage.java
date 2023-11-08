package lotto.constant;

public enum ErrorMessage {
    INPUT_ONLY_NUMBERS_ERROR_MESSAGE("[ERROR] 숫자만 입력해야 합니다."),
    MAX_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE("[ERROR] 구입 금액은 21억(2,100,000,000)이하인 양수로 입력해야 합니다."),
    PURCHASE_AMOUNT_LIMIT_CONSTRAINT_ERROR_MESSAGE("[ERROR] 구입 금액은 21억(2,100,000,000)이하로 입력해야 합니다."),
    POSITIVE_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE("[ERROR] 구입 금액은 양수로 입력해야 합니다."),
    PURCHASE_AMOUNT_UNITS_CONSTRAINT_ERROR_MESSAGE("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NULL_OR_EMPTY_INPUT_ERROR_MESSAGE("[ERROR] 입력값을 확인하세요."),
    CORRECT_SEPARATOR_INPUT_ERROR_MESSAGE("[ERROR] 쉼표(,)를 구분하여 입력하세요."),
    WINNING_NUMBER_OUT_OF_RANGE_MESSAGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    POSITIVE_LOTTO_NUMBER_CONSTRAINT_MESSAGE("[ERROR] 로또 번호는 양수를 입력해야 합니다."),
    DUPLICATE_NUMBER_CONSTRAINT_MESSAGE("[ERROR] 중복되는 숫자는 입력할 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE_MESSAGE("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다."),
    POSITIVE_BONUS_NUMBER_CONSTRAINT_MESSAGE("[ERROR] 보너스 숫자는 양수로 입력해야 합니다."),
    DUPLICATE_WINNING_NUMBER_CONSTRAINT_MESSAGE("[ERROR] 당첨 번호와 중복되는 숫자를 입력할 수 없습니다."),
    DUPLICATE_LOTTO_NUMBER_CONSTRAINT_MESSAGE("[ERROR] 중복되는 로또 번호가 있습니다.");

    private final String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
