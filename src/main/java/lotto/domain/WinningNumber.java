package lotto.domain;

import lotto.util.Message;

import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.duplicateNumberError);
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean containsWinningNumber(int number) {
        return winningNumbers.contains(number);
    }

    public boolean containsBonusNumber(List<Integer> list) {
        return list.contains(bonusNumber);
    }
}
