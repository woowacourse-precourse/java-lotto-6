package lotto.Global;

public enum Exception {
    WRONG_VALUE("[ERROR] 입력이 정상적으로 이루어지지 않았습니다."),
    NOT_NUMBER_VALUE("[ERROR] 숫자를 입력해주세요."),
    LOTTO_WRONG_AMOUNT_INPUT("[ERROR] 로또 번호는 1~45의 범위 내의 숫자여야합니다."),
    LOTTO_OUT_OF_RANGE_INPUT("[ERROR] 로또 번호는 %s으로 구분되어 6개가 입력되어야 합니다."),
    LOTTO_NO_DUPLICATE_CREATE("[ERROR] 로또 변호에는 중복이 없어야합니다."),
    LOTTO_PURCHASE_INPUT("[ERROR] 구입 금액은 1000으로 떨어지는 숫자여야합니다."),
    LOTTO_BONUS_NUMBER_INPUT("[ERROR] 1~45 범위의 당첨번호와 중복되지 않는 1개의 숫자를 입력해주세요.");

    private String errorPhrase;

    private Exception(String errorPhrase) {
        this.errorPhrase = errorPhrase;
    }

    public String getErrorPhrase() {
        return errorPhrase;
    }

    public String getErrorPhrase(String symbol) {
        return String.format(errorPhrase, symbol);
    }
}
