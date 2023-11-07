package lotto.model;

import static lotto.constant.Numbers.FIFTHAWARD;
import static lotto.constant.Numbers.FIRSTAWARD;
import static lotto.constant.Numbers.FORPERCENT;
import static lotto.constant.Numbers.FOURTHAWARD;
import static lotto.constant.Numbers.SECONDAWARD;
import static lotto.constant.Numbers.THIRDAWARD;
import static lotto.constant.Rank.FIFTHRANK;
import static lotto.constant.Rank.FIRSTRANK;
import static lotto.constant.Rank.FOURTHRANK;
import static lotto.constant.Rank.SECONDRANK;
import static lotto.constant.Rank.THIRDRANK;

import java.util.HashMap;

public class WinningReward {
    private Long winningReward;
    private Double rateOfReturn;

    public WinningReward() {
        this.winningReward = 0L;
        this.rateOfReturn = 0D;
    }

    public Double calculateRateOfReturn(HashMap<String, Integer> winningStatics, Integer lottoAmountofMoney) {
        Long totalWinningAward = calculateWinningReward(winningStatics);
        rateOfReturn = totalWinningAward.doubleValue() / lottoAmountofMoney.doubleValue();
        rateOfReturn = rateOfReturn * FORPERCENT.getLongValue();
        return rateOfReturn;
    }

    private Long calculateWinningReward(HashMap<String, Integer> winningStatics) {
        winningReward = winningReward + winningStatics.get(FIRSTRANK.getValue()) * FIRSTAWARD.getLongValue();
        winningReward = winningReward + winningStatics.get(SECONDRANK.getValue()) * SECONDAWARD.getLongValue();
        winningReward = winningReward + winningStatics.get(THIRDRANK.getValue()) * THIRDAWARD.getLongValue();
        winningReward = winningReward + winningStatics.get(FOURTHRANK.getValue()) * FOURTHAWARD.getLongValue();
        winningReward = winningReward + winningStatics.get(FIFTHRANK.getValue()) * FIFTHAWARD.getLongValue();
        return winningReward;
    }
}
