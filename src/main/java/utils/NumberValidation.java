package utils;

public class NumberValidation {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public void isOverMaxNumber(int number) {
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void isUnderMinNumber(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
