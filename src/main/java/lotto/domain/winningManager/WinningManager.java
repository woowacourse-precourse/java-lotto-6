package lotto.domain.winningManager;

import lotto.domain.inputOutput.output.WinningOutput;
import lotto.domain.lottoDrawMachine.lottoDraw.LottoDraw;
import lotto.domain.vendingMachine.lotto.Lotto;

import java.util.HashMap;
import java.util.List;

public class WinningManager {
    RateOfReturn rateOfReturn = new RateOfReturn();
    WinningCheck winningCheck = new WinningCheck();
    WinningOutput winningOutput = new WinningOutput();

    public void discrimination(List<Lotto> lottos, LottoDraw lottoDraw) {
        HashMap<Integer, Integer> ranksHashMap = winningCheck.checkRanks(lottos, lottoDraw);
       winningOutput.displayWinningStatistics(ranksHashMap);

        double lottoRateOfReturn = rateOfReturn.calculateRateOfReturn(ranksHashMap, lottos.size());
        winningOutput.displayRateOfReturn(lottoRateOfReturn);
    }
}
