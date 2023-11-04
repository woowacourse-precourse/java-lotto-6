package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public interface InputService {
    public Lotto inputWinningNumbers();
    public BonusNumber inputBonusNumber();
    public int inputPrice();
}
