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
        if(isWinningNumberContainBonusNumber(number)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_AND_BONUS_NUMBER_ARE_SAME.getErrorMessage());
            throw new IllegalArgumentException();
        }
        this.bonusNumber = number;

    }

    public boolean isWinningNumberContainBonusNumber(int number){
        return winningNumber.isContainNumber(number);
    }
}
