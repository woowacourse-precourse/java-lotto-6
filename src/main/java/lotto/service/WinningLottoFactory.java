package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public interface WinningLottoFactory {
    public Lotto winningLotto(String inputNumber);
    public BonusNumber bonusNumber(String inputBonusNumber);
}
