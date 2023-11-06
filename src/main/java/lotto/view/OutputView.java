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
        System.out.println(String.format(format, countOfLotto));
    }

    public static void showLotteries(Lotteries lotteries) {
        lotteries.showLotteries();
        System.out.println();
    }

    public static void showStatics(Map<String, Integer> statistics) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());
        System.out.println(String.format(OutputMessage.MATCHES_3_FORMAT.getMessage(), statistics.get(RankConstant.FIFTH)));
        System.out.println(String.format(OutputMessage.MATCHES_4_FORMAT.getMessage(), statistics.get(RankConstant.FOURTH)));
        System.out.println(String.format(OutputMessage.MATCHES_5_FORMAT.getMessage(), statistics.get(RankConstant.THIRD)));
        System.out.println(String.format(OutputMessage.MATCHES_5_ADDITION_BONUS_NUMBER_FORMAT.getMessage(), statistics.get(RankConstant.SECOND)));
        System.out.println(String.format(OutputMessage.MATCHES_6_FORMAT.getMessage(), statistics.get(RankConstant.FIRST)));
    }

    public static void showTotalReturn(double totalReturn) {
        System.out.println(String.format(OutputMessage.TOTAL_RETURN.getMessage(), totalReturn));
    }
}
