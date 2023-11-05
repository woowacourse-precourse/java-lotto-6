package lotto.domain;

public enum LottoRank {
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개"),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개"),
    TOTAL("총 수익률은 %.1f%%입니다.");

    private final String rankFormat;


    LottoRank(String messageFormat) {
        this.rankFormat = messageFormat;
    }

    public String getRankFormat() {
        return rankFormat;
    }
}
