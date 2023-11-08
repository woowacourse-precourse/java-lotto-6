package lotto.domain;

import java.util.List;

public class LottoResult {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoResult(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;

        validate();
    }

    public static LottoResult create(Lotto winningLotto, BonusNumber bonusNumber) {
        return new LottoResult(winningLotto, bonusNumber);
    }

    private void validate() {
        validateDuplicateBonusNumber();
    }

    private void validateDuplicateBonusNumber() {
        if (winningLotto.isContainsNumber(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumber() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
