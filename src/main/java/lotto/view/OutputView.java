package lotto.view;

import static lotto.consts.LottoConst.LOTTO_PRICE;
import static lotto.util.OutputFormat.addCommaAtIntegers;
import static lotto.util.OutputFormat.roundAtTwo;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    public static void printLottos(int money, List<Lotto> lottos) {
        int lottoQuantity = money / LOTTO_PRICE;
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(Map<LottoResult, Integer> lottoMap) {
        System.out.println("당첨 통계\n"
                + "---");

        for (LottoResult lottoResult : lottoMap.keySet()) {
            String result = lottoResult.getCount() + "개 일치";
            if (lottoResult.isValidBonus()) {
                result += ", 보너스 볼 일치";
            }
            result += " (" + addCommaAtIntegers(lottoResult.getPrize()) + "원) - " + lottoMap.get(lottoResult) + "개";
            System.out.println(result);
        }
    }

    public static void printPrizePercentage(double prizePercentage) {
        System.out.println("총 수익률은 " + roundAtTwo(prizePercentage) + "%입니다.");
    }

}