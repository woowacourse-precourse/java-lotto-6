package lotto.view;


import lotto.domain.LottoAmount;
import lotto.domain.LottoPlayer;
import lotto.domain.Rank;

import java.util.List;

import static lotto.util.Message.*;

public class OutputView {

    public static void printLottos(LottoAmount lottoAmount, LottoPlayer lottoPlayer) {
        System.out.println();
        System.out.println(lottoAmount.getLottoCount() + OUTPUT_MESSAGE);
        lottoPlayer.getLottos().forEach(System.out::println);
        System.out.println();

    }

    public static void showGameResult(List<Rank> results, LottoAmount lottoAmount) {
        System.out.println();
        System.out.println(STATISTIC_RESULT_MESSAGE);
        System.out.println(LINE_CHANGE_MESSAGE);

        for (Rank rank : Rank.getValidRanks()) {
            System.out.println(rank.getMessage() + rank.calculateCount(results) + "개");
        }

        System.out.println("총 수익률은 " + String.format("%,.1f", getEarningRate(Rank.calculateEarning(results), lottoAmount.getAmount())) + "%입니다.");
    }

    private static double getEarningRate(long profit, long inputMoney) {
        return (double) (profit * 100) / inputMoney;
    }


}
