package lotto.constant;

public enum Game {
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    TOTAL_PICK(6);

    private final int num;

    Game(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
