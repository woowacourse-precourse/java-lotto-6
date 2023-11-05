package lotto.model;

public enum LottoNumber {
    MIN(1),
    MAX(45),
    COUNT(6);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean isInRange(int number) {
        return number >= MIN.getNumber() && number <= MAX.getNumber();
    }
}
