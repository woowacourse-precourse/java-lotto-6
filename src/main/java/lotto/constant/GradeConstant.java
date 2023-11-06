package lotto.constant;

public enum GradeConstant {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int hit;
    private final int prize;

    GradeConstant(int hit, int prize) {
        this.hit = hit;
        this.prize = prize;
    }

    public int hit() {
        return hit;
    }

    public int prize() {
        return prize;
    }
}