package view;

import Constant.Rank;
import Constant.ViewMessage;
import java.text.DecimalFormat;
import java.util.Map;
import model.Lotto;
import model.MyLotto;

public class OutPutView {

    public static void printPurchaseResult(MyLotto myLotto) {
        System.out.printf(ViewMessage.PRINT_PURCHASE_RESULT.getMessage(), myLotto.getMyLotto().size());
        for (Lotto lotto : myLotto.getMyLotto()) {
            System.out.println(lotto.getSortedNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(Map<Rank, Integer> winningDetails) {
        System.out.print(ViewMessage.PRINT_WINNING_STATISTICS.getMessage());
        for (Rank rank : Rank.values()) {
            System.out.printf(rank.getDescription(), winningDetails.get(rank));
            System.out.println();
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        String fomattedString = new DecimalFormat("###,###.0").format(rateOfReturn);
        System.out.printf(ViewMessage.PRINT_RATE_OF_RETURN.getMessage(), fomattedString);
    }
}