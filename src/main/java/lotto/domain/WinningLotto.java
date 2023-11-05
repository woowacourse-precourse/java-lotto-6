package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
