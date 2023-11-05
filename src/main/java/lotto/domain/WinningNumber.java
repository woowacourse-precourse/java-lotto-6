package lotto.domain;

public class WinningNumber {

    private final int number;

    public WinningNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if(number < 1 || 45 < number) {
            throw new IllegalArgumentException();
        }
    }

}
