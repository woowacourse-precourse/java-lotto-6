package lotto;

public enum Constants {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000),
    COUNT_MIN(3);

    private final int num;

    Constants(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
