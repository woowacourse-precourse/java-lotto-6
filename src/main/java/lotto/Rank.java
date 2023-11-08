package lotto;

public enum Rank {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_AND_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    private final int countDuplication;
    private final boolean checkBonus;
    private final int prize;

    Rank(int countDuplication, boolean checkBonus, int prize) {
        this.countDuplication = countDuplication;
        this.checkBonus = checkBonus;
        this.prize = prize;
    }

    public static Rank decideRank(int countDuplication, boolean checkBonus) {
        Rank[] ranksSpreadInOrder = Rank.values();

        for (Rank rank : ranksSpreadInOrder) {
            if (rank.getCountDuplication() == countDuplication && rank.getCheckBonus() == checkBonus) {
                return rank;
            }
        }

        return null;
    }

    public int getCountDuplication() {
        return countDuplication;
    }

    public boolean getCheckBonus() {
        return checkBonus;
    }

    public int getPrize() {
        return prize;
    }
}