package lotto;

public enum Rank {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    int place;
    int prize;

    Rank(int place, int prize) {
        this.place = place;
        this.prize = prize;
    }

    public int getPlace() {
        return place;
    }

    public int getPrize() {
        return prize;
    }
}
