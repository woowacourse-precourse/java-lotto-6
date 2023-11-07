package lotto.domain;

public enum Ranking {
    FIRST("6개 일치 (2,000,000,000원)",2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    THIRD("5개 일치 (1,500,000원)", 1500000),
    FORTH("4개 일치 (50,000원)", 50000),
    FIFTH("3개 일치 (5,000원)",5000),
    SIXTH("꽝 (0원) ",0);

    private final String lotteryResult;
    private final int prizeMoney;

    Ranking(String lotteryResult, int prizeMoney) {
        this.lotteryResult = lotteryResult;
        this.prizeMoney = prizeMoney;
    }

    public String getLotteryResult() {
        return lotteryResult;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
