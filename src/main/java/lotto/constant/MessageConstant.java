package lotto.constant;

public enum MessageConstant {
    LOTTO_PRICE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),

    LOTTO_AMOUNT_OUTPUT_MESSAGE("%d개를 구매했습니다."),
    LOTTO_RESULT_OUTPUT_MESSAGE("당첨 통계\n---"),
    LOTTO_PROFIT_OUTPUT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int amount) {
        return message.formatted(amount);
    }

    public String getMessage(double profit) {
        return message.formatted(profit);
    }
}
