package view;

import Constant.Rank;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import model.Lotto;
import model.MyLotto;

public class OutPutView {

    private static final String PRINT_PURCHASE_RESULT = "%d개를 구매했습니다.\n";
    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---\n";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %s%%입니다.";

    public static void printPurchaseResult(MyLotto myLotto) {
        System.out.printf(PRINT_PURCHASE_RESULT, myLotto.getMyLotto().size());
        for (Lotto lotto : myLotto.getMyLotto()) {
            System.out.println(lotto.getSortedNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(Map<Rank, Integer> winningDetails) {
        System.out.print(PRINT_WINNING_STATISTICS);
        for (Rank rank : Rank.values()) {
            System.out.printf(rank.getDescription(), winningDetails.get(rank));
            System.out.println();
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        NumberFormat numberFormat = new DecimalFormat("###,###.0");
        String str = numberFormat.format(rateOfReturn);
        System.out.printf(PRINT_RATE_OF_RETURN, str);
    }
}