package domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    void setWinningNumber(List<Integer> numbers) {
        this.winningNumber = new Lotto(numbers);
    }

    void setBonusNumber(int number) {
        this.bonusNumber = bonusNumber;
    }

}
