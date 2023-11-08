package lotto;

public class Prize {
    private final Integer matchingNumbers;
    private final Boolean bonus;
    private final Rank rank;

    public Prize(Integer matchingNumbers, Boolean bonus) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
        this.rank = setRank();
    }


    Rank setRank() {
        if (this.matchingNumbers == 6) {
            return Rank.FIRST;
        }
        if (this.matchingNumbers == 5 & bonus) {
            return Rank.SECOND;
        }
        if (this.matchingNumbers == 5) {
            return Rank.THIRD;
        }
        if (this.matchingNumbers == 4) {
            return Rank.FOURTH;
        }
        if (this.matchingNumbers == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    int getPrize() {
        return this.rank.getPrize();
    }

    Rank getRank() {
        return this.rank;
    }


}
