package lotto.controller;

public enum GameConstants {

    LOTTO_NUMBER_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int number;

    GameConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
