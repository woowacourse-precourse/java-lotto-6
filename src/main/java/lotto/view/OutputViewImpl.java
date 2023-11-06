package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;

public class OutputViewImpl implements OutputView {
    @Override
    public void printBoughtLotto(List<Lotto> boughtLotto) {
        System.out.printf("%s개를 구매했습니다.%s", boughtLotto.size(), System.lineSeparator());
        for (Lotto lotto : boughtLotto) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    @Override
    public void printWinningStatistics(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        result.forEachOrdered(lottoPrize ->
                System.out.printf(lottoPrize.getMessage(), result.getResult(lottoPrize), System.lineSeparator()));
    }

    @Override
    public void printTotalReturn(Double totalReturn) {
        System.out.printf("총 수익률은 %s%%입니다.", String.format("%.1f", totalReturn * 100));
    }

    @Override
    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
        System.out.println();
    }
}
