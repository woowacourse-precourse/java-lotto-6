package lotto.domain.constants;

public enum LottoStatisticsConstants {
    DOTTED_LINE("---"),
    INLINE("\n"),
    STATISTICS_NOTICE("당첨 통계");

    private String value;

    LottoStatisticsConstants(final String s) {
    }

    public static String getStatisticsPrefix() {
        return STATISTICS_NOTICE.getValue() + INLINE.getValue() + DOTTED_LINE.getValue() + INLINE.getValue();
    }

    public String getValue() {
        return value;
    }
}
