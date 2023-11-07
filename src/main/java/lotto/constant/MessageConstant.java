package lotto.constant;

public enum MessageConstant {
    BUY_LOTTO_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    PRIZE_STATS_MESSAGE("당첨 통계");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
