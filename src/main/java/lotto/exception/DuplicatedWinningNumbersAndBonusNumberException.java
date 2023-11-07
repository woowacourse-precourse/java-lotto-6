package lotto.exception;

public class DuplicatedWinningNumbersAndBonusNumberException extends IllegalArgumentException {
    public DuplicatedWinningNumbersAndBonusNumberException(String message) {
        super(message);
    }
}