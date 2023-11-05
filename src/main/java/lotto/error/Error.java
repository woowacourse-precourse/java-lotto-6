package lotto.error;

public class Error {
    final int LOTTO_PRICE = 1000;

    public boolean isInRange(int number) {
        return true;
    }

    public boolean isNegative(int number) {
        return number < 0;
    }

    public boolean isDigit(char digit) {
        return Character.isDigit(digit);
    }

    public boolean isRemainder(int number) {
        int remainder = number % LOTTO_PRICE;
        return remainder == 0;
    }
}
