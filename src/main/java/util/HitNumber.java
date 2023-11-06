package util;

public enum HitNumber {
    HIT_THREE_NUMBER(3),
    HIT_FOUR_NUMBER(4),
    HIT_FIVE_NUMBER(5),
    HIT_SIX_NUMBER(6);
    private final int number;

    HitNumber(int number) {
        this.number = number;
    }

    public int getHitNumber() {
        return number;
    }

}
