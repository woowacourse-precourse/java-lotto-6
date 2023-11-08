package lotto.domain;

public enum Rank {
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    EMPTY(0,0,false,"0개 일치");

    private final int prize;
    private final int matchCount;
    private final boolean bonus;
    private final String message;

    Rank(int prize, int matchCount, boolean bonus, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.message = message;
    }

    private static int getMatchCount(Lotto lotto, Lotto winningLotto) {
        int matchCount = 0;
        for(int number : lotto.getNumbers()) {
            if(winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private static boolean validateBonus(Lotto lotto, int bonusNum) {
        if(lotto.getNumbers().contains(bonusNum)) {
            return true;
        }
        return false;
    }

    public static Rank getRank(Lotto lotto, Lotto winningLotto, int bonusNum) {
        int matchCount = getMatchCount(lotto, winningLotto);
        boolean bonus = validateBonus(lotto, bonusNum);

        if(matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if(matchCount == SECOND.matchCount && bonus == SECOND.bonus) {
            return SECOND;
        }
        if(matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if(matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if(matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return EMPTY;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}
