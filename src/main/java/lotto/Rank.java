package lotto;

import view.OutputView;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 "), SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 "),
    THIRD(5, 1500000, "5개 일치 "), FOURTH(4, 50000, "4개 일치 "),
    FIFTH(3, 5000, "3개 일치 "), LOSE(2, 0);

    private int sameCount;
    private int prize;
    private String message;

    Rank(int sameCount, int prize, String message) {
        this.sameCount = sameCount;
        this.prize = prize;
        this.message = message;
    }

    Rank(int sameCount, int prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public static Rank getRank(int sameCount, boolean sameBonusNumber) {
        if (sameCount == FIRST.sameCount) {
            return FIRST;
        }

        if (sameCount == SECOND.sameCount && sameBonusNumber) {
            return SECOND;
        }

        if (sameCount == THIRD.sameCount) {
            return THIRD;
        }

        if (sameCount == FOURTH.sameCount) {
            return FOURTH;
        }

        if (sameCount == FIFTH.sameCount) {
            return FIFTH;
        }

        return LOSE;
    }

    public void printMessage(Rank rank, int count) {
        OutputView.printStatistic(message, rank.prize, count);
    }

    public int getPrize() {
        return prize;
    }
}
