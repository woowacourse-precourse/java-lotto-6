package lotto.exception;

import static lotto.constraint.PurchaseAmountConstraint.MINIMUM_PURCHASE_UNIT_AMOUNT;
import static lotto.constraint.LottoConstraint.TOTAL_NUMBERS_OF_LOTTO;

public enum ErrorMessage {
    INPUT_IS_NULL("null 값이 입력 되었습니다."),
    INPUT_IS_EMPTY("빈 값이 입력 되었습니다."),

    PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE("구입금액이 두 개 이상 존재합니다."),
    PURCHASE_AMOUNT_IS_NOT_NUMBER("구입금액이 수가 아닙니다."),
    PURCHASE_AMOUNT_IS_NEGATIVE_NUMBER("구입금액에 음수 값이 포함되어 있습니다."),
    PURCHASE_AMOUNT_IS_LESS_THAN_MINIMUM_AMOUNT(String.format("구입금액이 %d원보다 적은 금액입니다.", MINIMUM_PURCHASE_UNIT_AMOUNT.getValue())),
    PURCHASE_AMOUNT_IS_NOT_DIVIDED_UNIT_AMOUNT(String.format("구입금액이 %d원으로 나눠지지 않습니다." , MINIMUM_PURCHASE_UNIT_AMOUNT.getValue())),

    LOTTO_NUMBER_HAS_NOT_NUMBER_FORMAT("로또 번호 중 수가 아닌 값이 존재합니다."),
    LOTTO_NUMBER_HAS_OUT_OF_BOUND_NUMBER("범위를 벗어난 로또 번호가 존재합니다."),
    LOTTO_NUMBER_HAS_DUPLICATED_NUMBER("로또 번호 중 중복된 값이 존재합니다."),
    LOTTO_SIZE_IS_NOT_VALID(String.format("총 로또 번호의 개수가 %d가 아닙니다.", TOTAL_NUMBERS_OF_LOTTO.getValue()));

    private static final String ERROR_HEAD = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_HEAD + errorMessage;
    }
}