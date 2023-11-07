package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.enums.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void showPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void showPurchaseLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void showResult(LottoResult lottoResult, long money) {
        for (Map.Entry<LottoRank, Integer> entry : getLottoResultEntry(lottoResult)) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            System.out.println(rank.getMessage() + count + "개");
        }

        System.out.println("총 수익률은 " + String.format("%,.1f", lottoResult.getEarningRate(money)) + "%입니다.");
    }

    public static List<Map.Entry<LottoRank, Integer>> getLottoResultEntry(LottoResult lottoResult) {
        return lottoResult.getLottoResult().entrySet()
                .stream()
                .filter(entry -> entry.getKey() != LottoRank.NONE)
                .toList();
    }
}
