package lotto.common.constants;

public enum OutputMessage {
    INPUT_BUY_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_BUY_LOTTO_COUNT("개를 구매했습니다."),
    INPUT_HIT_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_HIT_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PRIZE_STATS("당첨 통계"),
    OUTPUT_TOTAL_PROFIT_PRICE_START("총 수익률은 "),
    OUTPUT_TOTAL_PROFIT_PRICE_END(Unit.PERCENT.getUnit() + "입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
