package lotto.domain;

import java.util.List;
import lotto.exception.DuplicateNumberException;

public class WinnerLotto {

    private final BonusNumber bonusNumber;
    private final Lotto lotto;

    public WinnerLotto(List<Integer> playerLotto, Integer bonusNumber) {
        lotto = new Lotto(playerLotto);
        validateDuplicateBonus(playerLotto, bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public boolean matchesLottoNumber(int lottoNumber) {
        return lotto.getNumbers()
                .contains(lottoNumber);
    }

    public boolean matchesBonusNumber(int bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }

    private void validateDuplicateBonus(List<Integer> playerLotto, Integer bonusNumber) {
        if (playerLotto.contains(bonusNumber)) {
            throw new DuplicateNumberException();
        }
    }
}
