package lotto.model.strategy;

import java.util.EnumMap;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;
import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.LottoRank;

public interface LottoStrategy {
    LottoRank determineLottoRank(Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber);
    RankCount determineRankCounts(LottoTicket lottoTicket, WinningLotto winningLotto, BonusNumber bonusNumber);
}
