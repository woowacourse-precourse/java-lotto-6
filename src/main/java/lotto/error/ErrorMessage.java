package lotto.error;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new UnsupportedOperationException();
    }

    public static final String INVALID_PURCHASE_AMOUNT_FORMAT = "구입 금액이 정수 형태가 아닙니다";
    public static final String INVALID_WINNING_NUMBER_FORMAT = "당첨 번호가 정수 형태가 아닙니다";
    public static final String INVALID_BONUS_NUMBER_FORMAT = "보너스 번호가 정수 형태가 아닙니다";
    public static final String NEGATIVE_PURCHASE_AMOUNT = "구입 금액이 양수가 아닙니다";
    public static final String NOT_DIVIDED_PURCHASE_AMOUNT = "구입 금액이 1000으로 나누어 떨어지지 않습니다";
    public static final String INVALID_LOTTO_NUMBER_LENGTH = "로또 번호 길이가 유효하지 않습니다";
    public static final String DUPLICATED_LOTTO_NUMBER = "로또 번호가 중복됩니다";
}
