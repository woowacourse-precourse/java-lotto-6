package lotto.config;

public enum GameConfig {

    LOTTO_PRICE(1000),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_LENGTH(6),
    ;

    private final int number;

    GameConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
