package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoResultFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void IssuedLottoNumbers(int amount, List<Lotto> lottos) {
        System.out.println("\n" + amount / 1000 + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void LottoResults(Map<LottoResultFormat, Integer> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoResultFormat key : lottoResults.keySet()) {
            if (key == LottoResultFormat.FIVE_BONUS && key != LottoResultFormat.FAIL) {
                System.out.print(key.getLottoOfMatching()+"개 일치, ");
                System.out.print(String.format("보너스 볼 일치 (%,d원) - ", key.getWinningAmount()));
                System.out.println(lottoResults.getOrDefault(key, 0) + "개");
            }
            if (key != LottoResultFormat.FIVE_BONUS && key != LottoResultFormat.FAIL) {
                System.out.print(key.getLottoOfMatching()+"개 일치 ");
                System.out.print(String.format("(%,d원) - ", key.getWinningAmount()));
                System.out.println(lottoResults.getOrDefault(key, 0) + "개");
            }
        }

    }

    public static void totalReturnOnLotto(double returnOnLotto) {
        System.out.println(String.format("총 수익률은 %,.1f%%입니다.", returnOnLotto));
    }
}
