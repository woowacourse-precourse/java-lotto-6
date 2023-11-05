package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public void printLottos(List<Lotto> myLottos) {
        for (int i = 0; i < myLottos.size(); i++) {
            System.out.println(Arrays.toString(myLottos.get(i).getNumbers().toArray()));
        }
    }

    public void printResult(LottoResult lottoResult, int input) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            System.out.println(String.format("%d개 일치%s (%,d원) - %d개",
                    rank.getMatchCount(),
                    (rank == Rank.SECOND ? ", 보너스 볼 일치" : ""),
                    rank.getWinningMoney(),
                    lottoResult.getCount(rank)));
        }

        Double profitRate = lottoResult.calculateProfitRate(input);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate * 100));
    }
}
