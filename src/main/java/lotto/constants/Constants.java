package lotto.constants;

public enum Constants {
    SAME_3(5000),
    SAME_4(50000),
    SAME_5(1500000),
    SAME_5_BONUS(30000000),
    SAME_6(2000000000);

    private final int prize;

    Constants(int prize) {
        this.prize = prize;
    }

    public double getPrize() {
        return prize;
    }
}
