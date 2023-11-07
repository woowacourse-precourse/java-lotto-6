package lotto.domain;

public enum Ranking {
    FIFTH("3개 일치 (5,000원)", 5_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000);

    private final String criteria;
    private final int prize;

    Ranking(String criteria, int prize) {
        this.criteria = criteria;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getCriteria() {
        return criteria;
    }

    public static Ranking of(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        return FIFTH;
    }
}
