package lotto.domain;

import lotto.util.CompareLotto;
import lotto.util.Rank;

/**
 * 각 등수의 수와 총상금 금액 저장
 */
public class CompareResult {
    private final int[] matchingCounts; //각 등수별 횟수

    public CompareResult(Lottos lottos, WinningLotto winningLotto) { //로또들을 넣어서 각 로또 마다 비교
        matchingCounts = WinningCount(lottos, winningLotto);
    }


    public static int[] WinningCount(Lottos lottos, WinningLotto winningLotto) { //로또들의 상금 횟수
        int[] matchingCounts = new int[Rank.values().length]; //우승자리만큼

        lottos.getLottos().forEach(lotto -> {
            Rank rank = CompareLotto.compareWinningWithLotto(lotto, winningLotto);//당첨 번호와 비교
            matchingCounts[rank.ordinal()]++;
        });

        return matchingCounts;

    }

    public int[] getMatchingCounts() {
        return matchingCounts;
    }
}
