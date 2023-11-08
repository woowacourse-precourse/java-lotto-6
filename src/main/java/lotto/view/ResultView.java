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
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> result = lottoResult.getResult();

        List<Rank> ranks = Arrays.asList(Rank.values());
        ranks.sort(Collections.reverseOrder());

        for (Rank rank : ranks) {
            if (rank == Rank.MISS) continue;
            int count = result.getOrDefault(rank, 0);
            String message = rank.getMatchCount() + "개 일치";
            if (rank == Rank.SECOND) {
                message += ", 보너스 볼 일치";
            }
            message += " (" + String.format("%,d원", rank.getPrize()) + ") - " + count + "개";
            System.out.println(message);
        }

        double returnRate = lottoResult.calculateReturnRate(purchaseAmount);
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
