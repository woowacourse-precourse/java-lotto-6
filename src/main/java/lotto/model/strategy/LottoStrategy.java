package lotto.model.strategy;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.LottoRank;

public interface LottoStrategy {
    LottoRank determineRank(LottoTicket lottoTicket, WinningLotto winningLotto, BonusNumber bonusNumber);
}
