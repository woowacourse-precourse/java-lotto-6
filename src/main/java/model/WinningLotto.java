package model;

import consts.LottoConsts;
import exception.DuplicateLottoNumberException;
import exception.WrongRangeLottoNumberException;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, Integer number) {
        if (winningLotto.contains(number) || winningLotto.size() > LottoConsts.LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }
}
