package lotto.domain;

import java.util.Arrays;

public enum Rank {
    First(6, false, 2_000_000, "6개 일치 (2,000,000,000원)"),
    Second(5, true, 30_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    Third(5, false, 1_500, "5개 일치 (1,500,000원)"),
    Fourth(4, false, 50, "4개 일치 (50,000원)"),
    Fifth(3, false, 5, "3개 일치 (5,000원)"),
    None(0, false, 0, "");
    private int numberOfCorrect;
    private boolean hitBonusNumber;
    private int costForCalculate;
    private String costForShow;

    Rank(int numberOfCorrect, boolean hitBonusNumber, int costForCalculate, String costForShow) {
        this.numberOfCorrect = numberOfCorrect;
        this.hitBonusNumber = hitBonusNumber;
        this.costForCalculate = costForCalculate;
        this.costForShow = costForShow;
    }

    public static Rank getRank(int numberOfCorrect, boolean hitBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(info -> info.numberOfCorrect == numberOfCorrect && info.hitBonusNumber == hitBonusNumber)
                .findAny()
                .orElse(None);
    }

    public int getCostForCalculate() {
        return costForCalculate;
    }

    public String getCostForShow() {
        return costForShow;
    }
}
