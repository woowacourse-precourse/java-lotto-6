package lotto.model.data;

import static lotto.util.PrizeDetails.FIFTH_PRIZE;
import static lotto.util.PrizeDetails.FIRST_PRIZE;

import lotto.model.calculator.WinningCalculator;
import lotto.model.record.RateOfReturn;

public class WinningPortfolio {
    private WinningStatus winningStatus;
    private RateOfReturn rateOfReturn;

    public WinningPortfolio(WinningStatus winningStatus) {
        this.winningStatus = winningStatus;
    }

    public Integer getCountOfPrize(Integer prize) {
        return winningStatus.countOfPlace(prize);
    }

    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
    }

    public void updateRateOfReturn(LottoRecipe lottoRecipe) {
        Integer investmentMoney = lottoRecipe.getMoney().money();
        Long prizeMoney = 0L;
        for (int prize = FIRST_PRIZE.getPrize(); prize <= FIFTH_PRIZE.getPrize(); prize++) {
            prizeMoney += winningStatus.calculatePrizeMoney(prize, winningStatus.countOfPlace(prize));
        }

        rateOfReturn = new RateOfReturn(WinningCalculator.calculateRateOfReturn(investmentMoney.intValue(), prizeMoney));
    }
}
