package lotto.model;

import java.util.HashMap;

public class WinningReward {
    private Long winningReward;
    private Double rateOfReturn;

    private final Long FIRSTAWARD = 2000000000L;
    private final Long SECONDAWARD = 30000000L;
    private final Long THIRDAWARD = 1500000L;
    private final Long FOURTHAWARD = 50000L;
    private final Long FIFTHAWARD = 5000L;
    private final Long FORPERCENT = 100L;

    public WinningReward() {
        this.winningReward = 0L;
        this.rateOfReturn = 0D;
    }

    public Double calculateRateOfReturn(HashMap<String, Integer> winningStatics, Integer lottoAmountofMoney) {
        Long totalWinningAward = calculateWinningReward(winningStatics);
        rateOfReturn = totalWinningAward.doubleValue() / lottoAmountofMoney.doubleValue();
        rateOfReturn = rateOfReturn * FORPERCENT;
        return rateOfReturn;
    }

    private Long calculateWinningReward(HashMap<String, Integer> winningStatics) {
        winningReward = winningReward + winningStatics.get("FIRST") * FIRSTAWARD;
        winningReward = winningReward + winningStatics.get("SECOND") * SECONDAWARD;
        winningReward = winningReward + winningStatics.get("THIRD") * THIRDAWARD;
        winningReward = winningReward + winningStatics.get("FOURTH") * FOURTHAWARD;
        winningReward = winningReward + winningStatics.get("FIFTH") * FIFTHAWARD;
        return winningReward;
    }
}
