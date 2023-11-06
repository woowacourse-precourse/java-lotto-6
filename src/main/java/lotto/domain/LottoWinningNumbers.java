package lotto.domain;

import java.util.List;
import lotto.domain.wrapper.BonusNumber;

public class LottoWinningNumbers {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = Lotto.create(winningNumbers);
        this.bonusNumber = BonusNumber.create(bonusNumber);
    }

    public static LottoWinningNumbers create(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
