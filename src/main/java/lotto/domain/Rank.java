package lotto.domain;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);






    private final int correctNumbers;
    private final int winnings;

    Rank(int correctNumbers, int winnings) {
        this.correctNumbers = correctNumbers;
        this.winnings = winnings;
    }

    public int getCorrectNumbers() {
        return correctNumbers;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Rank valueOf(int correctNumbers, boolean isBonus) {
        if (correctNumbers == 6) {
            return FIRST;
        }
        if (correctNumbers == 5 && isBonus) {
            return SECOND;
        }
        if (correctNumbers == 5) {
            return THIRD;
        }
        if (correctNumbers == 4) {
            return FOURTH;
        }
        if (correctNumbers == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
