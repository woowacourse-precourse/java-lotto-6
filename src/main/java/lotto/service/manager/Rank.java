package lotto.service.manager;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5_000, "5,000"),
    FOURTH(4, 50_000, "50,000"),
    THIRD(5, 1_500_000, "1,500,000"),
    SECOND(5, 30_000_000, "30,000,000"),
    FIRST(6, 2_000_000_000, "2,000,000,000"),
    ;

    private final int countForRank;
    private final int prize;
    private final String prizeFormat;

    Rank(final int countForRank, final int prize, final String prizeFormat) {
        this.countForRank = countForRank;
        this.prize = prize;
        this.prizeFormat = prizeFormat;
    }

    /**
     *
     * @param countForRank 당첨 번호와 일치하는 숫자의 개수
     * @param didHitsBonusNumber 보너스 숫자 일치 여부
     * @return 일치하는 Rank. 만약 일치하는 Rank가 없다면 null 반환.
     */
    public static Rank findRank(final int countForRank, final boolean didHitsBonusNumber) {
        if (isSecond(countForRank, didHitsBonusNumber)) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(r -> r != SECOND)
                .filter(r -> r.countForRank == countForRank)
                .findFirst()
                .orElse(null);
    }

    private static boolean isSecond(final int countForRank, final boolean didHitsBonusNumber) {
        return countForRank == SECOND.countForRank && didHitsBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getCountForRank() {
        return countForRank;
    }

    public String getPrizeFormat() {
        return prizeFormat;
    }
}
