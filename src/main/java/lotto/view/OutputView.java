package lotto.view;

import lotto.domain.Constant.OutputViewMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.OutputLottoResult;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printAttempt(int cash) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", cash / 1000);
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void printStat(OutputLottoResult outputLottoResult) {
        System.out.println();
        System.out.println(OutputViewMessage.PRINT_STAT.getMessage());

        System.out.printf(OutputViewMessage.PRINT_STAT_MATCH3.getMessage(), outputLottoResult.getMatch3());
        System.out.printf(OutputViewMessage.PRINT_STAT_MATCH4.getMessage(), outputLottoResult.getMatch4());
        System.out.printf(OutputViewMessage.PRINT_STAT_MATCH5.getMessage(), outputLottoResult.getMatch5());
        System.out.printf(OutputViewMessage.PRINT_STAT_MATCH5_AND_BONUS.getMessage(), outputLottoResult.getMatch5AndBonus());
        System.out.printf(OutputViewMessage.PRINT_STAT_MATCH6.getMessage(), outputLottoResult.getMatch6());
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(OutputViewMessage.PRINT_RATE_OF_RETURN.getMessage(), rateOfReturn);
    }
}
