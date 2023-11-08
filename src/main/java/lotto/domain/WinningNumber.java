package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }
}
