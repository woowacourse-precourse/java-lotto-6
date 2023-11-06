package lotto.constant;

public enum LottoAnnouncer {

    LOTTO_LIST("[%s]"),
    PRIZE_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    ACCORDANCE_THREE("3개 일치 (5,000원) - %d개"),
    ACCORDANCE_FOUR("4개 일치 (50,000원) - %d개"),
    ACCORDANCE_FIVE("5개 일치 (1,500,000원) - %d개"),
    ACCORDANCE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    ACCORDANCE_SIX("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1lf입니다.");

    private final String message;

    LottoAnnouncer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
