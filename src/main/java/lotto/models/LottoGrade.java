package lotto.models;

public enum LottoGrade {

    NONE(6, 0, 0, false),
    FIFTH(5, 5000, 3, false),
    FOURTH(4, 50000, 4, false),
    THIRD(3, 1500000, 5, false),
    SECOND(2, 30000000, 5, true),
    FIRST(1, 2000000000, 6, false);

    final int rank;
    final int prizeMoney;
    final int matchCount;
    final boolean matchBonus;

    LottoGrade(int rank, int prizeMoney, int matchCount, boolean matchBonus) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(matchCount).append("개 일치");
        if (matchBonus) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(String.format("%,d", prizeMoney)).append("원)");
        return sb.toString();
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
