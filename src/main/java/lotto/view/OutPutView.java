package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.HashMap;

public class OutPutView {

    public void outPutViewLottos(Lottos lottos, int userMoney) {
        System.out.println();
        int lottoCount = lottos.numberLottos(userMoney);

        System.out.println(lottoCount + "개를 구매했습니다.");
        System.out.println(lottos);
        System.out.println();
    }

    public void outPutViewWinningStatistics(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        HashMap<Rank, Integer> result = lottoResult.getResult();

        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(Rank.MATCH_3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(Rank.MATCH_4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(Rank.MATCH_5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(Rank.MATCH_5_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(Rank.MATCH_6, 0) + "개");
    }

}
