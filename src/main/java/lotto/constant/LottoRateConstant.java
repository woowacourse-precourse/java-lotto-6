package lotto.constant;

public enum LottoRateConstant {
    PURCHASE_NUM_MESSAGE("\n%d개를 구매했습니다."),
    FIFTH_LOTTO_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_LOTTO_MESSAGE("4개 일치 (50,000원) - %d개"),
    THIRD_LOTTO_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    SECOND_LOTTO_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_LOTTO_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_RETURN_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoRateConstant(String message) {
        this.message = message;
    }

    public String getMessage(int value) {
        return String.format(message, value);
    }

    public String getMessage(double value) {
        return String.format(message, value);

    }
}
