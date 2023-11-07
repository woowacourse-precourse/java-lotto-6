package lotto.domain.common;

public enum Rank {

    FIFTH("3개 일치 (5,000원)", 3, false, 5_000),
    FOURTH("4개 일치 (50,000원)", 4, false, 50_000),
    THIRD("5개 일치 (1,500,000원)", 5, false, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, true, 30_000_000),
    FIRST("6개 일치 (2,000,000,000원)", 6, false, 2_000_000_000);

    private final String info;
    private final Integer matchCount;
    private final Boolean isMatchWithBonus;
    private final Integer prize;

    Rank(String info, Integer matchCount, Boolean isMatchWithBonus, Integer prize) {
        this.info = info;
        this.matchCount = matchCount;
        this.isMatchWithBonus = isMatchWithBonus;
        this.prize = prize;
    }

    public String getInfo() {
        return info;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Boolean getIsMatchWithBonus() {
        return isMatchWithBonus;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(int count) {
        return count * prize;
    }
}
