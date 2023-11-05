package lotto;

public enum Settings {
    PURCHASE_UNIT(1000);

    private final int number;

    Settings(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
