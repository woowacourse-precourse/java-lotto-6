package lotto.domain.constants;

public enum LottoStatisticsConstants {
    DOTTED_LINE("---"),
    INLINE("\n"),
    STATISTICS_NOTICE("당첨 통계"),
    PROFIT_RATE_NOTICE("총 수익률은 %.1f%%입니다.");

    private final String value;

    LottoStatisticsConstants(final String value) {
        this.value = value;
    }


    public String getValue() {
        return this.value;
    }
}
