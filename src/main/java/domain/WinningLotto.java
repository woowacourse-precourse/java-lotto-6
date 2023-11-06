package domain;

import constant.ConstantNumber;
import constant.ExceptionMessage;

import java.util.List;

public class WinningLotto {
    public int bonusNumber;
    private Lotto lotto;

    public WinningLotto() {

    }

    WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber > ConstantNumber.MAXIMUM_WINNING_NUMBER.get() ||
                bonusNumber < ConstantNumber.MINIMUM_WINNING_NUMBER.get()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.get());
        }
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        vaildateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.lotto = new Lotto(winningNumber);
    }
}
