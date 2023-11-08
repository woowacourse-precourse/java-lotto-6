package lotto.message;

public enum ErrorMessage {
    INVALID_BUY_AMOUNT_INPUT("로또 구매 금액은 1000원 단위의 숫자로 입력해주세요. (최소 구매 금액: 1000원)"),
    INVALID_LOTTERY_NUMBERS("당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다."),
    DUPLICATE_LOTTERY_NUMBERS("중복된 로또 번호가 존재합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자 1개여야 합니다."),
    DUPLICATE_BONUS_NUMBER("당첨 번호 중 중복된 번호가 존재합니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
