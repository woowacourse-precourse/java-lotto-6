package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public WinningNumber(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }
}
