package lotto;

public enum LottoPrize {
    FIFTH(5_000, "3개 일치 "),
    FOURTH(50_000, "4개 일치 "),
    THIRD(1_500_000, "5개 일치 "),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 "),
    FIRST(2_000_000_000, "6개 일치 ");


    private final int prize;
    private final String description;
    private int count;

    LottoPrize(int prize, String description) {
        this.prize = prize;
        this.description = description;
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }

    public int getPrize() {
        return this.prize;
    }

    public void increaseCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return description + "(" + String.format("%,d", this.prize) + "원) - " + this.count + "개";
    }
}
