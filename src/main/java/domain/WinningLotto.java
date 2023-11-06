package domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public void setWinningNumber(List<Integer> numbers) {
        this.winningNumber = new Lotto(numbers);
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumberContainBonusNumber(int number){
        return winningNumber.isContainNumber(number);
    }
}
