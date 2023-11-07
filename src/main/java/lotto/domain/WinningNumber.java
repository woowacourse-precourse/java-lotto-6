package lotto.domain;

public class WinningNumber {
    private static final String WINNING_NUMBER_MUST_NUMERIC_MESSAGE = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    private static final String WINNING_NUMBER_RANGE_MESSAGE = "[ERROR] 당첨 번호는 1~45의 숫자여야 합니다.";
    private static final int START_RANGE_VALUE = 1;
    private static final int END_RANGE_VALUE = 45;
    private final int winningNumber;

    private WinningNumber(int winningNumber) {
        validateRange(winningNumber);
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

    private static void validateRange(int number) {
        if (isOverRange(number)) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_MESSAGE);
        }
    }

    private static boolean isOverRange(int number) {
        return number < START_RANGE_VALUE || number > END_RANGE_VALUE;
    }

    public int toInt() {
        return this.winningNumber;
    }

    public boolean isEqualsBonusNumber(int bonusNumber) {
        return this.winningNumber == bonusNumber;
    }
}
