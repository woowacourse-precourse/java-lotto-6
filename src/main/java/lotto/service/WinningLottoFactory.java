package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public interface WinningLottoFactory {
    Lotto winningLotto(String inputNumber);
    BonusNumber bonusNumber(String inputBonusNumber, Lotto lotto);
}
