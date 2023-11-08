package lotto.model;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;
import lotto.model.lotto.WinningLotto;
import lotto.model.machine.LottoMachine;
import lotto.model.machine.RandomLottoMachine;
import lotto.model.strategy.LottoStrategy;
import lotto.model.strategy.MyLottoStrategy;

public class LottoGame {
    public LottoTicket generateLottoTicket(Budget budget){
        LottoMachine lottoMachine = new RandomLottoMachine();
        return new LottoTicket(budget, lottoMachine);
    }

    public RankCount calculateRankCount(LottoTicket lottoTicket, WinningLotto winningLotto, BonusNumber bonusNumber){
        LottoStrategy lottoStrategy = new MyLottoStrategy();
        return lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
    }

    public Revenue calculateRevenue(RankCount rankCount, Budget budget){
        return new Revenue(rankCount, budget);
    }
}
