package lotto;

public enum Winning {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_AND_BONUS(7, 30000000),
    SIX(6, 2000000000);


    private final Integer label;
    private final Integer prize;


    Winning(Integer label, Integer prize) {
        this.label = label;
        this.prize = prize;
    }

    public Integer getLabel() {
        return label;
    }

    public Integer getPrize() {
        return prize;
    }

    public static Winning getWinning(Integer label) {
        for (Winning winning : Winning.values()) {
            if (winning.getLabel() == label) {
                return winning;
            }
        }
        return null;
    }
}
