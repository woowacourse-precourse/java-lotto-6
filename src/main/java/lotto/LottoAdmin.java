package lotto;

import java.util.List;

public class LottoAdmin {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoAdmin(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
