package lotto.model;

public class Number {

    private final static int WINNING_NUMBER_MIN_RANGE = 1;
    private final static int WINNING_NUMBER_MAX_RANGE = 45;

    private final int winningNumber;

    public Number(int winningNumber) {
        validateWinningNumberRange(winningNumber);
        this.winningNumber = winningNumber;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    private void validateWinningNumberRange(int winningNumber) {
        if (winningNumber < WINNING_NUMBER_MIN_RANGE || winningNumber > WINNING_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
