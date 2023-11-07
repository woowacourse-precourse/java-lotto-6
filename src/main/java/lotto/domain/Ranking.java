package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum Ranking {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5,true),
    THIRD(1500000, 5,false),
    FOURTH(50000, 4,false),
    FIFTH(5000, 3,false);

    private final int prize;
    private final int count;
    private final boolean hasBonusNumber;

    Ranking(int prize, int count,boolean hasBonusNumber) {
        this.prize = prize;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking findRanking(int count, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == count && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(null);
    }
    public long multiple(Integer count) {
        return (long) prize * count;
    }

    public String formatPrizeInfo(int count) {
        if (this.equals(Ranking.SECOND)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", this.count, formatPrize(this.prize));
        }
        return String.format("%d개 일치 (%s원)", this.count, formatPrize(this.prize));
    }

    public String  formatPrize(int prize) {
        return String.format("%,d", prize);
    }
    public static Comparator<Ranking> sortByPrizeDescending() {
        return Comparator.comparingInt((Ranking ranking) -> ranking.prize).reversed();
    }
}
