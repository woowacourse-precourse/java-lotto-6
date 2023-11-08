package lotto.global.exception;

public enum LottoException {
    INVALID_PURCHASE_AMOUNT_STRING_VALIDATION("[ERROR] 숫자만 입력이 가능합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT_VALIDATION("[ERROR] 금액은 1,000 단위로 입력할 수 있습니다."),
    MINIMUM_PURCHASE_AMOUNT_NOT_MET_VALIDATION("[ERROR] 최소 구매 금액은 1,000원 입니다."),
    MAXIMUM_PURCHASE_AMOUNT_NOT_MET_VALIDATION("[ERROR] 최대 구매 금액은 1,000,000,000원 미만입니다."),
    LOTTO_NUMBERS_DUPLICATE_VALIDATION("[ERROR] 당첨 번호는 중복이 되면 안 됩니다."),
    LOTTO_NUMBERS_SIZE_VALIDATION("[ERROR] 당첨 번호는 6개입니다."),
    LOTTO_NUMBER_RANGE_VALIDATION("[ERROR] 당첨 번호는 1 이상 45 이하 입니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE_VALIDATION("[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안 됩니다."),
    ;
    private final String defaultMessage;

    LottoException(String message) {
        this.defaultMessage = message;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

}
