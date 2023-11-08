package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private MainNumbers mainNumbers;
    private BonusNumber bonusNumber;

    public void setMainNumbers(List<Integer> mainNumbers) {
        this.mainNumbers = new MainNumbers(mainNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = new BonusNumber(mainNumbers.toList(), bonusNumber);
    }


    public boolean isMainNumber(int number) {
        return mainNumbers.isMainNumber(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber.isBonusNumber(number);
    }
}
