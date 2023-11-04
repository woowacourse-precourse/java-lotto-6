package lotto.view;

import static lotto.consts.LottoConst.LOTTO_PRICE;
import static lotto.consts.ViewConst.OUTPUT_BUY_LOTTO;
import static lotto.consts.ViewConst.OUTPUT_LOTTO_BENEFIT_PERCENTAGE;
import static lotto.consts.ViewConst.OUTPUT_LOTTO_RESULT;
import static lotto.consts.ViewConst.OUTPUT_LOTTO_RESULT_BONUS;
import static lotto.consts.ViewConst.OUTPUT_RESULT_LOTTOS;
import static lotto.util.OutputFormat.addCommaAtIntegers;
import static lotto.util.OutputFormat.roundAtTwo;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    public static void printLottos(int money, List<Lotto> lottos) {
        int lottoQuantity = money / LOTTO_PRICE;
        System.out.printf(OUTPUT_BUY_LOTTO, lottoQuantity);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(Map<LottoResult, Integer> lottoMap) {
        System.out.println(OUTPUT_RESULT_LOTTOS);

        for (LottoResult lottoResult : lottoMap.keySet()) {
            if (lottoResult.isValidBonus()) {
                System.out.printf(OUTPUT_LOTTO_RESULT_BONUS, lottoResult.getCount(),
                        addCommaAtIntegers(lottoResult.getPrize()),
                        lottoMap.get(lottoResult));
                continue;
            }
            System.out.printf(OUTPUT_LOTTO_RESULT, lottoResult.getCount(), addCommaAtIntegers(lottoResult.getPrize()),
                    lottoMap.get(lottoResult));
        }
    }

    public static void printPrizePercentage(double prizePercentage) {
        System.out.printf(OUTPUT_LOTTO_BENEFIT_PERCENTAGE, roundAtTwo(prizePercentage));
    }

}