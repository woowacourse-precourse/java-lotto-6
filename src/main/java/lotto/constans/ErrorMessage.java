package lotto.constans;

public enum ErrorMessage {

    LOTTO_NUMBER_LENGTH_EXCEPTION("[ERROR] 로또 번호는 6자리 입니다."),
    WANT_BUY_AMOUNT_EXCEPTION("[ERROR] 구입 금액은 1000원 단위 입니다."),
    WINNING_NUMBER_LENGTH_EXCEPTION("[ERROR] 당첨 번호는 6자리 입니다."),
    IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능 합니다."),
    NUMBER_RANGE_EXCEPTION("[ERROR] 1~45 사이의 숫자만 가능 합니다."),
    NUMBER_DUPLICATED_EXCEPTION("[ERROR] 서로 다른 숫자만 가능 합니다."),
    BONUS_NUMBER_IS_CONTAIN_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호에 포함될수 없습니다."),
    WANT_BUY_AMOUNT_OVER_EXCEPTION("[ERROR] 1회에 10 만원 이상은 구매 블가합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
