package lotto.domain;

import static lotto.domain.exception.LottoException.DUPLICATED_BONUS_NUMBER;

import java.util.List;

public class LottoGame {
    private final Lotto winnerLotto;
    private final BonusNumber bonusNumber;

    private LottoGame(Lotto winnerLotto, BonusNumber bonusNumber) {
        validateDuplicates(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame by(Lotto winnerLotto, BonusNumber bonusNumber) {
        return new LottoGame(winnerLotto, bonusNumber);
    }

    private void validateDuplicates(Lotto winnerLotto, BonusNumber bonusNumber) {
        if (winnerLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winnerLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
