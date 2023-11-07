package lotto.view.message;

import static lotto.constant.LottoConfig.*;

public enum ValidationErrorMessage {

    LOTTO_NUMBER_OUT_OF_RANGE(String.format("숫자 범위가 %d~%d여야 합니다.", LOTTO_START_NUMBER.getValue(), LOTTO_END_NUMBER.getValue())),
    LOTTO_INVALID_DIGITS(String.format("로또가 %d자리가 아닙니다.", LOTTO_COUNT_NUMBER.getValue())),
    LOTTO_DUPLICATE_DIGITS("로또 번호에 중복이 있습니다."),
    LOTTO_BUNDLE_NULL("로또 묶음이 null 값 입니다."),
    LOTTO_BUNDLE_EMPTY("로또 묶음이 비어 있습니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE("구입 금액은 양수여야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_THOUSAND(String.format("구입 금액은 %d의 자리로 나눠 떨어져야 합니다.", TICKET_PRICE.getValue())),
    WINNING_NUMBER_INVALID_DIGITS(String.format("정답 갯수가 %d자리가 아닙니다.", LOTTO_COUNT_NUMBER.getValue())),
    WINNING_NUMBER_DUPLICATE_DIGITS("정답 번호에 중복이 있습니다."),
    INPUT_EMPTY("입력이 비었습니다."),
    INPUT_NOT_INTEGER("입력이 정수가 아닙니다."),
    INPUT_DUPLICATE_WITH_WINNING("입력하신 번호는 당첨 번호와 중복됩니다."),
    INPUT_WRONG_SEPARATOR("정수 형태의 입력이 쉼표로 구분 되어야 합니다.");

    private final String message;

    ValidationErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String errorMessage = "[ERROR] ";
        return errorMessage + message;
    }
}
