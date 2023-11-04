package lotto.enumerate;

public enum ErrorCode {
    LOTTO_NUMBER_OVER_OR_UNDER_SIZE("[ERROR] 1장의 로또 번호의 갯수는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOTTO_NUMBER_UNDER_OR_OVER("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다."),
    AMOUNT_UNIT_IS_NOT_1000_WON("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다."),
    AMOUNT_IS_UNDER_THOUSAND_WON("[ERROR] 로또 구입 금액은 음수이거나 0이 될 수 없습니다."),
    AMOUNT_IS_NOT_LONG("[ERROR] 로또 구입 금액은 숫자 형태 여야 합니다."),
    PROFIT_RATE_NOT_ROUNDED("[ERROR] 수익률이 반올림 되지 않았습니다."),
    PROFIT_RATE_DECIMAL_NOT_ONE("[ERROR] 수익률이 소숫점 한자리가 아닙니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
