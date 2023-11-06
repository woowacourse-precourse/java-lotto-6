package lotto;

import java.util.Arrays;

public enum LottoRank {
    LAST_PLACE(0, false, 0, null),
    FIFTH_PLACE(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH_PLACE(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD_PLACE(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND_PLACE(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int collectNumberCount;
    private final boolean isBonus;
    private final int prizeMoney;
    private final String outputMessage;

    LottoRank(int collectNumberCount, boolean isBonus, int prizeMoney, String outputMessage) {
        this.collectNumberCount = collectNumberCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.outputMessage = outputMessage;
    }

    public static LottoRank determineRank(long collectNumberCount, boolean isBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.collectNumberCount == collectNumberCount)
                .filter(rank -> rank.isBonus == isBonus)
                .findAny()
                .orElse(LAST_PLACE);
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
