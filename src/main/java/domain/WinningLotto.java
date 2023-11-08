package domain;

import util.ErrorMessage;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public void setWinningNumber(List<Integer> numbers) {
        this.winningNumber = new Lotto(numbers);
    }

    public void setBonusNumber(int number) {
        checkBonusNumberValidation(number);
        this.bonusNumber = number;
    }

    public boolean isEqualToWinningNumber(int number) {
        return winningNumber.isContainNumber(number);
    }

    public boolean isEqualToBonusNumber(int number) {
        return bonusNumber == number;
    }

    private void checkBonusNumberValidation(int bonusNumber) {
        if(winningNumber.isContainNumber(bonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_AND_BONUS_NUMBER_ARE_SAME.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
