package lotto.model;

import java.util.List;
import lotto.util.validate.WinningLottoValidator;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        WinningLottoValidator.validate(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchNumber(Lotto playerLotto) {
        List<Integer> numbers = lotto.getNumbers();

        return (int) playerLotto.getNumbers()
                .stream()
                .filter(numbers::contains)
                .count();

    }

    public boolean hasBonusNumber(Lotto playerLotto) {
        return playerLotto.getNumbers()
                .contains(bonusNumber.getBonusNumber());
    }
}
