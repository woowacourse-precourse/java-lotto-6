package lotto.domain;

public class ResultBuilder {

    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
    }

    public Result build() {
        return new Result(winningNumbers, bonusNumber);
    }

}
