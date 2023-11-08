package lotto.view;

import lotto.Constant;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INFO_PURCHASE_LOTTO = "개를 구매했습니다.";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";


    public static void printLottoNums(List<Lotto> list) {
        System.out.println(list.size() + INFO_PURCHASE_LOTTO);

        for (Lotto lotto : list) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static void printMatchedResult(Map<Rank, Integer> result) {
        for (Rank rank : result.keySet()) {
            if (!rank.isPrint()) {
                continue;
            }

            System.out.println(rank.getPrizeMessage() + result.get(rank) + Constant.LOTTO_COUNT_UNIT);
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
