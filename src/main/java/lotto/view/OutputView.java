package lotto.view;

import lotto.constant.RankConstant;
import lotto.domain.model.Lotteries;
import lotto.message.OutputMessage;

import java.util.Map;

public final class OutputView {

    private OutputView() {
    }

    public static void showCountOfLotto(int countOfLotto) {
        String format = OutputMessage.OUTPUT_COUNT_OF_LOTTO_FORMAT.getMessage();
        System.out.printf((format) + "%n", countOfLotto);
    }

    public static void showLotteries(Lotteries lotteries) {
        lotteries.showLotteries();
        System.out.println();
    }

    public static void showStatics(Map<String, Integer> statistics) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());
        System.out.printf((OutputMessage.MATCHES_3_FORMAT.getMessage()) + "%n", statistics.get(RankConstant.FIFTH));
        System.out.printf((OutputMessage.MATCHES_4_FORMAT.getMessage()) + "%n", statistics.get(RankConstant.FOURTH));
        System.out.printf((OutputMessage.MATCHES_5_FORMAT.getMessage()) + "%n", statistics.get(RankConstant.THIRD));
        System.out.printf((OutputMessage.MATCHES_5_ADDITION_BONUS_NUMBER_FORMAT.getMessage()) + "%n", statistics.get(RankConstant.SECOND));
        System.out.printf((OutputMessage.MATCHES_6_FORMAT.getMessage()) + "%n", statistics.get(RankConstant.FIRST));
    }

    public static void showTotalReturn(double totalReturn) {
        System.out.printf((OutputMessage.TOTAL_RETURN.getMessage()) + "%n", totalReturn);
    }
}
