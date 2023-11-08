package lotto.validation;

public enum LottoException {
    ERROR_MESSAGE("[ERROR] "),
    LETTER_ERROR_MESSAGE("숫자가 아닌 입력입니다."),
    EMPTY_INPUT_ERROR_MESSAGE("입력이 비어있습니다."),
    AMOUNT_ERROR_MESSAGE("구매 금액은 0보다 커야합니다."),
    MONEY_LEFT_ERROR_MESSAGE("구매 금액은 1000원 단위로 입력해야 합니다."),
    SIZE_ERROR_MESSAGE("로또 번호는 6개로 구성되어야 합니다."),
    OUT_RANGE_ERROR_MESSAGE("로또를 구성하는 번호는 1이상 45이하 자연수로 구성되어야 합니다."),
    DUPLICATION_ERROR_MESSAGE("로또를 구성하는 6개의 번호는 모두 다른 수로 구성되어야 합니다."),
    BONUS_DUPLICATION_ERROR_MESSAGE("보너스 번호는 6개의 숫자와 다른 숫자로 구성되어야 합니다.");

    private final String errorMessage;

    LottoException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return ERROR_MESSAGE + errorMessage;
    }
}
