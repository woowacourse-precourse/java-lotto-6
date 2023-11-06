package lotto;

public enum Message {

    ERROR_NOT_MULTIPLES_NUMBER("[ERROR] 로또 구입 금액은 " + LottoConstant.MIN_AMOUNT_OF_LOTTO.getValue() + " 원 단위어야 합니다."),
    ERROR_NOT_NUMBER_RANGE("[ERROR] 로또 구입 금액은 " + LottoConstant.MIN_AMOUNT_OF_LOTTO.getValue() + " ~ " + LottoConstant.MAX_AMOUNT_OF_LOTTO + " 원 이어야 합니다."),
    ERROR_NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    ERROR_NOT_IN_SPLIT_WORD("[ERROR] 구분자가 없습니다."),
    ERROR_NOT_NUMBERS_SIZE("[ERROR] 로또 번호는 "+ LottoConstant.LOTTO_NUMBER_SIZE.getValue() +"개 이어야 합니다."),
    ERROR_DUPLICATE_NUMBERS("[ERROR] 로또 번호에 중복이 있습니다."),
    ERROR_BONUS_IN_WINNER_NUMBERS("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."),

    INPUT_BUY_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNER_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

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
