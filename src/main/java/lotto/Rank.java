package lotto;

import java.util.List;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private final boolean isBonusMatch;

    Rank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    Rank(int matchCount, int prize, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public static Rank calculateRank(Lotto winLotto, int bonusNumber, Lotto userLotto) {
        int matchCount = 0;
        boolean bonusMatch = false;
        List<Integer> winNumbers = winLotto.getNumbers();
        List<Integer> userNumbers = userLotto.getNumbers();

        for (int number : userNumbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && userNumbers.contains(bonusNumber)) {
            bonusMatch = true;
        }

        return Rank.valueOf(matchCount, bonusMatch);
    }
}
