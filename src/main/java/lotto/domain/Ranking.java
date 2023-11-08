package lotto.domain;

public enum Ranking {
    MISS(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원) -"),
    FOURTH(4, 50000, "4개 일치 (50,000원) -"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) -"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) -");

    private int match;
    private int prize;
    private String mes;

    Ranking(int match, int prize, String mes) {
        this.match = match;
        this.prize = prize;
        this.mes = mes;
    }

    public static Ranking Matching(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        } else if (matchCount == 5 && matchBonus == true) {
            return SECOND;
        }
        for (Ranking r : values()) {
            if (r.match == matchCount && r != SECOND) {
                return r;
            }
        }
        return null;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }

    public String getMes() {
        return mes;
    }
}
