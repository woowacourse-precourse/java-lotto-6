package lotto.model;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 0, 2_000_000_000, "6개 일치"),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 0, 1_500_000, "5개 일치"),
    FOURTH(4, 0, 50_000, "4개 일치"),
    FIFTH(3, 0, 5_000, "3개 일치"),
    NO_WINNING(0, 0, 0, "");

    private final int matchLottoCount;
    private final int matchBonusCount;
    private final int reward;
    private final String contents;

    Ranking(int matchLottoCount, int matchBonusCount, int reward, String contents) {
        this.matchLottoCount = matchLottoCount;
        this.matchBonusCount = matchBonusCount;
        this.reward = reward;
        this.contents = contents;
    }

    public static Ranking getRanking(int matchLottoCount, int matchBonusCount) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchLottoCount == matchLottoCount)
                .filter(ranking -> ranking.matchBonusCount == matchBonusCount)
                .findFirst()
                .orElse(NO_WINNING);
    }

    public int getReward() {
        return this.reward;
    }

    public String getContents() {
        return this.contents;
    }
}
