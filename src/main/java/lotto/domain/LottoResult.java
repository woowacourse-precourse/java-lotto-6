package lotto.domain;

import java.util.List;

public class LottoResult {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoResult(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;

        valiate();
    }

    private LottoResult(List<Integer> winningNumber, String bonusNumber) {
        this(new Lotto(winningNumber), new BonusNumber(bonusNumber));
    }

    public static LottoResult create(List<Integer> winningNumber, String bonusNumber) {
        return new LottoResult(winningNumber, bonusNumber);
    }

    private void valiate() {
        validateDuplicateBonusNumber();
    }

    private void validateDuplicateBonusNumber() {
        if (winningLotto.isContainsNumber(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException();
        }
    }
}
