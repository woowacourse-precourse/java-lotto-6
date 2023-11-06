package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    THREE_MATCH(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원) - %d개"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    FIVE_MATCH_WITH_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;
    private final String outputString;

    LottoRank(int matchCount, boolean hasBonus, int prize, String outputString) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.outputString = outputString;
    }

    LottoRank(int matchCount, int prize, String outputString) {
        this(matchCount, false, prize, outputString);
    }

    public static LottoRank valueFrom(int matchCount, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> isTargetRank(lottoRank, matchCount, hasBonus))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("해당하는 점수가 없습니다."));
    }

    public static LottoRank valueFrom(int matchCount) {
        return valueFrom(matchCount, false);
    }

    private static boolean isTargetRank(LottoRank lottoRank, int matchCount, boolean hasBonus) {
        return lottoRank.matchCount == matchCount && lottoRank.hasBonus == hasBonus;
    }

    public String getOutputString(int resultCount) {
        return String.format(outputString, resultCount);
    }

}