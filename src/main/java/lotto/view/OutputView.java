package lotto.view;

import lotto.config.OutputMessage;
import lotto.config.LottoPrize;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.printf(OutputMessage.OUTPUT_LOTTO_COUNT.getMessage(), lottoCount);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(Arrays.toString(lotto.getNumbers().toArray())));
    }

    public static void printLottoResult(Map<LottoPrize, Integer> lottoResult) {
        System.out.printf(
                OutputMessage.OUTPUT_LOTTOS_NUMBER.getMessage(),
                lottoResult.get(LottoPrize.MATCH_3),
                lottoResult.get(LottoPrize.MATCH_4),
                lottoResult.get(LottoPrize.MATCH_5),
                lottoResult.get(LottoPrize.MATCH_5BONUS),
                lottoResult.get(LottoPrize.MATCH_6)
        );
    }

    public static void printLottoProfit(double profit) {
        System.out.printf(OutputMessage.OUTPUT_LOTTO_PROFIT.getMessage(), profit);
    }
}
