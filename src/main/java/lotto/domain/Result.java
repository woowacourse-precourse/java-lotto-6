package lotto.domain;

import lotto.configure.DomainConfiguration;

import java.util.Arrays;

/**
 * 주어진 당첨 번호와 발행된 로또를 바탕으로 각 등수를 몇 번 달성했는지 저장한다.
 */
public class Result {
    private final Integer[] countsOfEachRank;

    /**
     * 생성자.
     */
    public Result() {
        this.countsOfEachRank = new Integer[DomainConfiguration.RANGE_OF_RANK];
        Arrays.fill(this.countsOfEachRank, 0);
    }

    /**
     * lottoToProcess의 등수를 파악하고, 해당 등수의 카운트를 1 증가시킨다.
     * @param lottoToProcess 등수를 파악할 Lotto.
     * @param winningNumbers 당첨 번호.
     */
    public void addCount(Lotto lottoToProcess, WinningNumbers winningNumbers) {
        processLotto(lottoToProcess, winningNumbers);
    }

    private void processLotto(Lotto lotto, WinningNumbers winningNumbers) {
        int numOfMatches = lotto.compare(winningNumbers);
        if (!DomainConfiguration.RANK_PER_NUM_OF_MATCHES.containsKey(numOfMatches)) {
            return;
        }
        Integer rank = DomainConfiguration.RANK_PER_NUM_OF_MATCHES.get(numOfMatches);
        if (rank == DomainConfiguration.RANK_FOR_CHECK_BONUS_NUMBER) {
            rank += getOneIfBonusNumberMatches(lotto, winningNumbers.getBonusNumber());
        }
        this.countsOfEachRank[rank - 1]++;
    }

    private int getOneIfBonusNumberMatches(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    /**
     * rank에 해당하는 등수를 몇 번 달성했는지 값을 반환한다.
     * @param rank 달성 횟수를 확인할 등수.
     * @return 해당 등수의 달성 횟수.
     */
    public int getCount(int rank) {
        return this.countsOfEachRank[rank - 1];
    }

    /**
     * 내부적으로 계산된 당첨 총액과 purchasePrice로부터 수익률을 계산한다.
     * 수익률 계산식은 RateOfReturnCalculator.calculate에 정의돼 있다.
     * @param purchasePrice 로또 구입 금액.
     * @return 수익률.
     */
    public double calculateRateOfReturn(int purchasePrice) {
        return (double)RateOfReturnCalculator.calculate(calculateTotalReward(), purchasePrice);
    }

    private int calculateTotalReward() {
        int sum = 0;
        for (int i = 0; i < this.countsOfEachRank.length; i++) {
            sum += DomainConfiguration.REWARD_PER_RANK.get(i + 1) * this.countsOfEachRank[i];
        }
        return sum;
    }
}
