package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.*;

public class ResultView {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(LottoResult lottoResult, int purchaseAmount) {
        printWinningStatistics(lottoResult);
        printReturnRate(lottoResult, purchaseAmount);
    }

    private void printWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> result = lottoResult.getResult();
        List<Rank> ranks = Arrays.asList(Rank.values());
        ranks.sort(Collections.reverseOrder());

        for (Rank rank : ranks) {
            if (rank == Rank.MISS) continue;
            printSingleRankResult(rank, result.getOrDefault(rank, 0));
        }
    }

    private void printSingleRankResult(Rank rank, int count) {
        String message = rank.getMatchCount() + "개 일치";
        if (rank == Rank.SECOND) {
            message += ", 보너스 볼 일치";
        }
        message += " (" + String.format("%,d원", rank.getPrize()) + ") - " + count + "개";
        System.out.println(message);
    }

    private void printReturnRate(LottoResult lottoResult, int purchaseAmount) {
        double returnRate = lottoResult.calculateReturnRate(purchaseAmount);

        double roundedRate = Math.round(returnRate * 10) / 10.0;
        System.out.println("총 수익률은 " + roundedRate + "%입니다.");
    }

}
