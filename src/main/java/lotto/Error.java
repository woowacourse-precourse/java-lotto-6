package lotto;

import java.util.List;

public class Error {
    final int LOTTO_PRICE = 1000;

    public boolean isInRange(int number) {
        return (1 <= number && number <= 45);
    }

    public boolean isNegative(int number) {
        return number < 0;
    }

    private boolean isDigit(char digit) {
        return Character.isDigit(digit);
    }
    public boolean isStringDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isRemainder(int number) {
        int remainder = number % LOTTO_PRICE;
        return remainder == 0;
    }
    public boolean isDuplicate(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
