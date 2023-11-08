package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NO_WINNING(0, false, 0, "");

    private final int matchLottoCount;
    private final Boolean isMatchBonusCountEssential;
    private final int reward;
    private final String contents;

    Ranking(int matchLottoCount, Boolean isMatchBonusCountEssential, int reward, String contents) {
        this.matchLottoCount = matchLottoCount;
        this.isMatchBonusCountEssential = isMatchBonusCountEssential;
        this.reward = reward;
        this.contents = contents;
    }

    public static Ranking getRanking(int matchLottoCount, int matchBonusCount) {
        List<Ranking> rankingsByMatchLottoCount = Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchLottoCount == matchLottoCount)
                .toList();

        List<Ranking> properRankings = new ArrayList<>();

        for (Ranking ranking : rankingsByMatchLottoCount) {
            if (ranking.isMatchBonusCountEssential && matchBonusCount > 0) {
                properRankings.add(ranking);
            } else if (!ranking.isMatchBonusCountEssential) {
                properRankings.add(ranking);
            }
        }
        return properRankings.stream()
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
