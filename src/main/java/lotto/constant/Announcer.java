package lotto.constant;

public enum Announcer {

    PURCHASE_PAYMENT("구입금액을 입력해주세요."),
    LOTTO_NUMBER("당첨 번호를 입력해주세요."),
    LOTTO_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    LOTTO_LIST("[%s]"),
    PRIZE_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    RATE_OF_RETURN("총 수익률은 %.1lf입니다.");

    private final String message;

    Announcer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
