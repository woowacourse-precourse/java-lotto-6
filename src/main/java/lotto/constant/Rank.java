package lotto.constant;

import java.util.Optional;

public enum Rank {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000);

    int totalMatchedNumber;
    int matchedBonusNumber;
    int prize;

    Rank(int totalMatchedNumber, int matchedBonusNumber, int prize) {
        this.totalMatchedNumber = totalMatchedNumber;
        this.matchedBonusNumber = matchedBonusNumber;
        this.prize = prize;
    }

    public int getTotalMatchedNumber() {
        return totalMatchedNumber;
    }

    public int getMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static Optional<Rank> matchedNumberToRank(int totalMatchedNumber, int matchedBonusNumber) {
        for(Rank rank : Rank.values()) {
            if(totalMatchedNumber == rank.totalMatchedNumber && matchedBonusNumber == rank.matchedBonusNumber) {
                return Optional.of(rank);
            }
        }
        return Optional.empty();
    }
}
