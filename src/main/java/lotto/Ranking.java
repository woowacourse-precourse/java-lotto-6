package lotto;

public enum Ranking {
    FIRST("1등", "3개 일치 (5,000원)", 2_000_000_000),
    SECOND("2등", "4개 일치 (50,000원)", 30_000_000),
    THIRD("3등", "5개 일치 (1,500,000원)", 1_500_000),
    FOURTH("4등", "5개 일치, 보너스 볼 일치 (30,000,000원)", 50_000),
    FIFTH("5등", "6개 일치 (2,000,000,000원)",5_000),
    NONE("낙첨", "모든 번호 불일치",0);

    private final String rankingName;
    private final String criteria;
    private final int prize;

    Ranking(String rankingName, String criteria, int prize) {
        this.rankingName = rankingName;
        this.criteria = criteria;
        this.prize = prize;
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
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
