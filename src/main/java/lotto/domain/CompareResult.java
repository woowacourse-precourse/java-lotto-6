package lotto.domain;

import lotto.util.CompareLotto;
import lotto.util.Rank;

/**
 * 각 등수의 수와 총상금 금액 저장
 */
public class CompareResult {
    private final int[] matchingCounts; //각 등수별 횟수


    private final int sumOfWinning;
    private double returnRate;

    public CompareResult(Lottos lottos, WinningLotto winningLotto, Price price) { //로또들을 넣어서 각 로또 마다 비교
        matchingCounts = WinningCount(lottos, winningLotto);
        sumOfWinning = setSumOfWinning();
        returnRate = setReturnRate(price);
    }


    public static int[] WinningCount(Lottos lottos, WinningLotto winningLotto) { //로또들의 상금 횟수
        int[] matchingCounts = new int[Rank.values().length]; //우승자리만큼

        lottos.getLottos().forEach(lotto -> {
            Rank rank = CompareLotto.compareWinningWithLotto(lotto, winningLotto);//당첨 번호와 비교
            matchingCounts[rank.ordinal()]++;
        });

        return matchingCounts;

    }

    private int setSumOfWinning() {
        int sumOfWinning = 0;
        for (int firstToFif = Rank.FIRST.ordinal(); firstToFif <= Rank.FIFTH.ordinal(); firstToFif++) {
            if (matchingCounts[firstToFif] > 0) {
                sumOfWinning += Rank.values()[firstToFif].getPrize() * matchingCounts[firstToFif];
            }
        }
        return sumOfWinning;
    }

    private double setReturnRate(Price price) {
        int expense = price.getPrice();
        double profitRatio = ((double) sumOfWinning / expense) * 100.0;
        return profitRatio;
    }

    public int[] getMatchingCounts() {
        return matchingCounts;
    }

    public Double getReturnRate() {
        return returnRate;
    }

    public int getSumOfWinning() {
        return sumOfWinning;
    }
}
