package lotto.enums;

public enum LottoNumber {
    COUNT(6),
    MIN(1),
    MAX(45),
    PRICE(1000);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean isOutOfRange(int number) {
        return number < MIN.getNumber() || number > MAX.getNumber();
    }
}
