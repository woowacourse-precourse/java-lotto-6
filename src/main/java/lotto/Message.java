package lotto;

public enum Message {

    ERROR_NOT_MULTIPLES_NUMBER("[ERROR] 로또 구입 금액은 " + LottoConstant.MIN_AMOUNT_OF_LOTTO.getValue() + " 원 단위어야 합니다."),
    ERROR_NOT_NUMBER_RANGE("[ERROR] 로또 구입 금액은 " + LottoConstant.MIN_AMOUNT_OF_LOTTO.getValue() + " ~ " + LottoConstant.MAX_AMOUNT_OF_LOTTO + " 원 이어야 합니다."),
    ERROR_NOT_NUMBER("[ERROR] 숫자가 아닙니다."),

    INPUT_BUY_AMOUNT("구입금액을 입력해 주세요."),

    LOTTO_BUY_COUNT("개를 구매했습니다."),

    CRLF("");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
