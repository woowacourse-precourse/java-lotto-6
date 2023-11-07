package lotto.domain;

public class WinningNumbersFactory {

    public static WinningNumbers createWinningNumbers(String winningNumbersInput, int bonusNumber) {
        return new WinningNumbers(winningNumbersInput, bonusNumber);
    }
}
