package lotto.model.data;

import static lotto.util.PrizeDetails.FIFTH_PRIZE;
import static lotto.util.PrizeDetails.FIRST_PRIZE;

import lotto.model.calculator.WinningCalculator;
import lotto.model.record.RateOfReturn;

/**
 * 당첨 내역과 수익률을 포함한 로또 게임의 결과를 나타낸다.
 */
public class WinningPortfolio {
    private WinningStatus winningStatus;
    private RateOfReturn rateOfReturn;

    /**
     * 당첨 내역을 가진 WinningPortfolio를 생성한다.
     *
     * @param winningStatus 로또 번호와 정답 번호를 비교한 결과인 당첨 내역
     */
    public WinningPortfolio(WinningStatus winningStatus) {
        this.winningStatus = winningStatus;
    }

    /**
     * 특정 등수의 당첨 횟수를 반환한다.
     *
     * @param prize 당첨된 등수
     * @return 해당 등수의 당첨 횟수
     */
    public Integer getCountOfPrize(Integer prize) {
        return winningStatus.countOfPlace(prize);
    }

    /**
     * 수익률을 반환한다.
     *
     * @return 수익률
     */
    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
    }

    /**
     * 투자금과 총 상금을 이용하여 수익률을 계산하고 업데이트한다.
     * 총 상금은 각각의 등수에 대한 상금을 기반으로 계산된다.
     *
     * @param lottoRecipe 업데이트된 수익률을 반영하는 LottoRecipe
     */
    public void updateRateOfReturn(LottoRecipe lottoRecipe) {
        Integer investmentMoney = lottoRecipe.getMoney().money();
        Long prizeMoney = 0L;
        for (int prize = FIRST_PRIZE.getPrize(); prize <= FIFTH_PRIZE.getPrize(); prize++) {
            prizeMoney += winningStatus.calculatePrizeMoney(prize);
        }

        rateOfReturn = new RateOfReturn(WinningCalculator.calculateRateOfReturn(investmentMoney.intValue(), prizeMoney));
    }
}
