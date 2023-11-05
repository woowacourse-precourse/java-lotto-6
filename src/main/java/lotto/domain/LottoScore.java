package lotto.domain;

public class LottoScore {
    private int sameCount;
    private boolean isBonusContains;

    public LottoScore(int sameCount, boolean isBonusContains) {
        this.sameCount = sameCount;
        this.isBonusContains = isBonusContains;
    }

    public Winner getWinners() {
        return Winner.of(sameCount, isBonusContains);
    }


}
