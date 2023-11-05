package lotto.domain.constant;

import java.util.Arrays;

public enum Rank {
    First(6, false, 2_000_000, "6개 일치 (2,000,000,000원)", 1),
    Second(5, true, 30_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", 2),
    Third(5, false, 1_500, "5개 일치 (1,500,000원)", 3),
    Fourth(4, false, 50, "4개 일치 (50,000원)", 4),
    Fifth(3, false, 5, "3개 일치 (5,000원)", 5),
    None(0, false, 0, "", 0);
    private int numberOfCorrect;
    private boolean hitBonusNumber;
    private int costForCalculate;
    private String costForShow;
    private int rankNumber;

    Rank(int numberOfCorrect, boolean hitBonusNumber, int costForCalculate, String costForShow, int rankNumber) {
        this.numberOfCorrect = numberOfCorrect;
        this.hitBonusNumber = hitBonusNumber;
        this.costForCalculate = costForCalculate;
        this.costForShow = costForShow;
        this.rankNumber = rankNumber;
    }

    public static Rank getRank(int numberOfCorrect, boolean hitBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(info -> info.numberOfCorrect == numberOfCorrect && info.hitBonusNumber == hitBonusNumber)
                .findAny()
                .orElse(None);
    }

    public static Rank toRank(int rankNumber) {
        return Arrays.stream(Rank.values())
                .filter(info -> info.rankNumber == rankNumber)
                .findAny()
                .orElse(None);
    }

    public int getCostForCalculate() {
        return costForCalculate;
    }

    public String getCostForShow() {
        return costForShow;
    }

    public int getRankNumber() {
        return rankNumber;
    }
}
