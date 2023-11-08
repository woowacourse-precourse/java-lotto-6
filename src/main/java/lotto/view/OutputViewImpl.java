package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;

import java.text.DecimalFormat;
import java.util.List;

public class OutputViewImpl implements OutputView {

    public static final String BOUGHT_LOTTO_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    public static final String RANK_PREFIX = String.format("당첨 통계%n" + "---");
    public static final String PRIZE_MESSAGE_FORMAT = "%s (%s원) - %d개";
    public static final String PRIZE_NUMBER_FORMAT = "###,###";
    public static final String TOTAL_RETURN_PREFIX = "총 수익률은 %s%%입니다.";
    public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    @Override
    public void printBoughtLotto(List<Lotto> boughtLotto) {
        System.out.printf(BOUGHT_LOTTO_AMOUNT_MESSAGE_FORMAT, boughtLotto.size());
        for (Lotto lotto : boughtLotto) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    @Override
    public void printWinningStatistics(Result result) {
        System.out.println(RANK_PREFIX);
        result.forEachOrdered(rank ->
                System.out.println(convertWinningStatisticFormat(result, rank)));
    }

    @Override
    public void printTotalReturn(Double totalReturn) {
        System.out.printf(TOTAL_RETURN_PREFIX, String.format("%.1f", totalReturn * 100));
    }

    @Override
    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    private String convertWinningStatisticFormat(Result result, Rank rank) {
        return String.format(PRIZE_MESSAGE_FORMAT, rank.getMessage(),
                convertPrizeFormat(rank.getPrize()),
                result.getResult(rank));
    }

    private String convertPrizeFormat(Integer prize) {
        return new DecimalFormat(PRIZE_NUMBER_FORMAT).format(prize);
    }
}
