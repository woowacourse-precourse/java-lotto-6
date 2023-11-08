package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;

public class OutputViewImpl implements OutputView {

    public static final String BOUGHT_LOTTO_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    public static final String RANK_PREFIX = String.format("당첨 통계%n" + "---");
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
                System.out.printf(rank.getMessage(), result.getResult(rank), System.lineSeparator()));
    }

    @Override
    public void printTotalReturn(Double totalReturn) {
        System.out.printf(TOTAL_RETURN_PREFIX, String.format("%.1f", totalReturn * 100));
    }

    @Override
    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
