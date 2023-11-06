package lotto.view;

import static lotto.constant.MessageConstant.LOTTO_AMOUNT_OUTPUT_MESSAGE;
import static lotto.constant.MessageConstant.LOTTO_PROFIT_OUTPUT_MESSAGE;
import static lotto.constant.MessageConstant.LOTTO_RESULT_OUTPUT_MESSAGE;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    public static void printLottoAmount(int lottoAmount) {
        System.out.println(LOTTO_AMOUNT_OUTPUT_MESSAGE.getMessage(lottoAmount));
    }

    public static void printPlayerLotto(List<Lotto> playerLottos) {
        playerLottos.forEach(System.out::println);
    }

    public static void printMatchLotto(Map<LottoResult, Integer> lottoResult) {
        System.out.println();
        System.out.println(LOTTO_RESULT_OUTPUT_MESSAGE.getMessage());
        for (LottoResult result : LottoResult.values()) {
            printLottoResult(result, lottoResult.get(result));
        }
    }

    private static void printLottoResult(LottoResult result, Integer winningCount) {
        if (result != LottoResult.MISS) {
            System.out.println(result.getMessage(winningCount));
        }
    }

    public static void printProfit(double computeProfit) {
        System.out.printf(LOTTO_PROFIT_OUTPUT_MESSAGE.getMessage(computeProfit));
    }
}
