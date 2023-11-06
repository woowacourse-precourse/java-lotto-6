package lotto.exception;

import static lotto.constraint.PurchaseAmountConstraint.MINIMUM_PURCHASE_UNIT_AMOUNT;

public enum ErrorMessage {
    INPUT_IS_NULL("null 값이 입력 되었습니다."),
    INPUT_IS_EMPTY("빈 값이 입력 되었습니다."),

    PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE("구입금액이 두 개 이상 존재합니다."),
    PURCHASE_AMOUNT_IS_NOT_NUMBER("구입금액이 수가 아닙니다."),
    PURCHASE_AMOUNT_IS_NEGATIVE_NUMBER("구입금액에 음수 값이 포함되어 있습니다."),
    PURCHASE_AMOUNT_IS_LESS_THAN_MINIMUM_AMOUNT(String.format("구입금액이 %d원보다 적은 금액입니다.", MINIMUM_PURCHASE_UNIT_AMOUNT.getValue())),
    PURCHASE_AMOUNT_IS_NOT_DIVIDED_UNIT_AMOUNT(String.format("구입금액이 %d원으로 나눠지지 않습니다." , MINIMUM_PURCHASE_UNIT_AMOUNT.getValue()));

    private static final String ERROR_HEAD = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_HEAD + errorMessage;
    }
}