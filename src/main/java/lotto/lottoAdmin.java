package lotto;

import java.util.List;

public class lottoAdmin {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public lottoAdmin(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
