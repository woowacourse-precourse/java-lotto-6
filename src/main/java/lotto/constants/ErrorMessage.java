package lotto.constants;

public enum ErrorMessage {
    INVALID_ZERO_OR_NEGATIVE_PURCHASE("[ERROR] 0이나 음수는 입력할 수 없습니다."),
    INVALID_NON_NUMERIC_PURCHASE("[ERROR] 숫자를 입력해주세요."),
    INVALID_NON_NUMERIC("[ERROR] 숫자를 입력해주세요."),
    INVALID_AMOUNT_NOT_DIVISIBLE("[ERROR] 올바른 금액을 입력해주세요."),
    INVALID_COUNT("[ERROR] 6개의 숫자를 입력해주세요."),
    INVALID_LOTTO_NUMBER("[ERROR] 1에서 45 사이의 숫자만 입력할 수 있습니다."),
    INVALID_DUPLICATE_NUMBER("[ERROR] 중복된 번호는 입력할 수 없습니다."),
    INVALID_BONUS_DUPLICATE("[ERROR] 당첨 번호에 존재하는 번호입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
