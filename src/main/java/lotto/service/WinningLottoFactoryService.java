package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public interface WinningLottoFactoryService {
    Lotto winningLotto(String inputNumber);
    BonusNumber bonusNumber(String inputBonusNumber, Lotto lotto);
}
