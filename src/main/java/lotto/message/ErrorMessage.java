package lotto.message;

public enum ErrorMessage implements MessageProvider{
    INVALID_INPUT("[ERROR] 입력이 잘못되었습니다."),
    INVALID_PURCHASE_PRICE_FORMAT("[ERROR] 구매 가격이 될 수 없는 입력입니다."),
    INVALID_PARSE_INT("[ERROR] 숫자로 변환할 수 없는 형식입니다."),
    INVALID_COUNT_FORMAT("[ERROR] 숫자 형식으로 입력해주세요."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 1,000원 단위로 입력해주세요."),
    INVALID_UNIQUE_FORMAT("[ERROR] 중복되지 않는 숫자를 입력해주세요."),
    INVALID_WINNING_NUMS_COUNT("[ERROR] 당첨 번호는 6개 입력이 필요합니다."),
    INVALID_WINNING_NUMS_VALUE("[ERROR] 당첨 번호는 1 ~ 45 사이의 유효한 범위의 숫자여야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
