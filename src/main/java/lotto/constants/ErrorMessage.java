package lotto.constants;

public enum ErrorMessage {
    AMOUNT_FORMAT("[ERROR] 구입 금액은 정수(1000원 이상 2,147,483,000원 이하)로 입력해주세요."),
    AMOUNT_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해주세요."),
    AMOUNT_INVALID("[ERROR] 구입 금액은 1000원 이상으로 입력해주세요."),
    WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호는 중복되지 않는 0 ~ 45 사이의 숫자로 입력해주세요. (쉼표 \",\" 로 구분)");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
