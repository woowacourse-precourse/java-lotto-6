package lotto.domain;

public class WinningNumber {
    private static final String WINNING_NUMBER_MUST_NUMERIC_MESSAGE = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    private final int winningNumber;

    private WinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber from(String winningNumber) {
        try {
            int convertWinningNumber = Integer.parseInt(winningNumber);
            return new WinningNumber(convertWinningNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(WINNING_NUMBER_MUST_NUMERIC_MESSAGE);
        }
    }
}
