package lotto.domain;

import java.util.List;

public class WinningNumber extends Lotto {
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
