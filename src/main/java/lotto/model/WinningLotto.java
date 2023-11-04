package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}