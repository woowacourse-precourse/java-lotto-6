package lotto.messages;

public enum ErrorMessages {
    LOTTO_PURCHASE_FORMAT_ERROR("[ERROR] 1,000원 단위로 떨어지는 입력 해야 합니다. 다시 입력해 주세요."),
    LOTTO_PURCHASE_MIN_ERROR("[ERROR] 1,000원 이상 입력해야 합니다. 다시 입력해 주세요."),
    WINNING_NUMBERS_COUNT_ERROR("[ERROR] 6개의 숫자가 입력되어야 합니다. 다시 입력해 주세요."),
    NUMBERS_OUT_OF_RANGE("[ERROR] 1 - 45 사이의 수만 입력해야 합니다. 다시 입력해 주세요."),
    NON_NUMERIC_INPUT("[ERROR] 숫자 이외의 메시지가 포함되어 있습니다. 다시 입력해 주세요."),
    DUPLICATE_VALUE_FOUND("[ERROR] 중복된 값이 있습니다. 다시 입력해 주세요.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
