package lotto.constants;

public enum ErrorMessage {
    PURCHASE_AMOUNT_WRONG_UNIT_INPUT("[ERROR] 1,000원 단위로 입력해 주세요."),
    PURCHASE_AMOUNT_NOT_DIGIT("[ERROR] 숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_ZERO("[ERROR] 0보다 큰 금액을 입력해 주세요."),
    PURCHASE_AMOUNT_NULL_INPUT("[ERROR] 값을 입력해 주세요."),

    LOTTO_NUMBER_WRONG_SIZE("[ERROR] 6개의 숫자로 구성되어야 합니다."),
    LOTTO_NUMBER_NOT_IN_RANGE("[ERROR] 1~45 사이의 숫자만 가능합니다."),
    LOTTO_NUMBER_NOT_UNIQUE("[ERROR] 중복된 숫자는 불가능합니다."),
    LOTTO_NUMBER_NOT_ASCENDING("[ERROR] 오름차순으로 정렬되어야 합니다."),

    WINNING_NUMBER_WRONG_SEPARATOR("[ERROR] 쉼표(,)를 기준으로 구분합니다."),

    BONUS_NUMBER_NOT_DIGIT("[ERROR] 숫자를 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
