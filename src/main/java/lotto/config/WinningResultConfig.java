package lotto.config;

public enum WinningResultConfig {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);


    private int number;

    WinningResultConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
