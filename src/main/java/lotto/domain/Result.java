package lotto.domain;

public class Result {

    private final WinningNumbers winningNumbers;
    private final WinningNumber bonusNumber;

    public Result(WinningNumbers winningNumbers, WinningNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean winningNumbersContain(int number) {
        return winningNumbers.contains(number);
    }

    public boolean bonusNumberIs(int number) {
        return bonusNumber.is(number);
    }

}
