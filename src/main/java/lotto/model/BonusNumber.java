package lotto.model;

import static lotto.constant.Magic.NUMBER_POSITIVE;

import java.util.regex.Matcher;

public class BonusNumber {

    private int number;

    private Lotto winningNumber;

    public BonusNumber(String number, Lotto winningNumber) throws IllegalArgumentException {
        validatePositive(number.trim());
        validateIs1_45(number.trim());
        this.winningNumber = winningNumber;
        validateNotSameWinning(number.trim());
        this.number = parstInt(number.trim());
    }

    public int getNumber() {
        return number;
    }

    public int parstInt(String num) {
        return Integer.parseInt(num);

    }

    private void validateIs1_45(String input) throws IllegalArgumentException {
        int num = parstInt(input);
        if (!((0 < num) && (num < 46))) {
            throw new IllegalArgumentException();
        }

    }

    private void validatePositive(String input) throws IllegalArgumentException {
        Matcher matcher = NUMBER_POSITIVE.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotSameWinning(String input) throws IllegalArgumentException {
        int num = parstInt(input);

        if (winningNumber.getNumbers().contains(num)) {
            throw new IllegalArgumentException();
        }
    }
}
