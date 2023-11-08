package lotto.model;

import java.util.List;

public class LottoAnswer {
    private final Lotto winningNumbers;
    private final int bounsNumber;

    public LottoAnswer(Lotto winningNumbers, int bounsNumber) {
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bounsNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
