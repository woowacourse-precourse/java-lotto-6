package lotto.constant;

public final class RankConstant {
    /**
     * 6개 번호 일치
     */
    public static final String FIRST = "FIRST";
    public static final long FIRST_WINNINGS = 2_000_000_000L;

    /**
     * 5개 번호 + 보너스 번호 일치
     */
    public static final String SECOND = "SECOND";
    public static final long SECOND_WINNINGS = 30_000_000L;

    /**
     * 5개 번호 일치
     */
    public static final String THIRD = "THIRD";
    public static final long THIRD_WINNINGS = 1_500_000L;

    /**
     * 4개 번호 일치
     */
    public static final String FOURTH = "FOURTH";
    public static final long FOURTH_WINNINGS = 50_000L;

    /**
     * 3개 번호 일치
     */
    public static final String FIFTH = "FIFTH";
    public static final long FIFTH_WINNINGS = 5_000L;

    /**
     * 해당 없음
     */
    public static final String NONE = "NONE";
}
