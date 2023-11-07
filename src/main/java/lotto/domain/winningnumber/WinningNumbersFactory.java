package lotto.domain.winningnumber;

public class WinningNumbersFactory {

    private WinningNumbersFactory() {}

    public static WinningNumbers createWinningNumbers(String winningNumbersInput, int bonusNumber) {
        return new WinningNumbers(winningNumbersInput, bonusNumber);
    }
}
