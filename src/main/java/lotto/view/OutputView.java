package lotto.view;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.LEFT_BRACKET;
import static lotto.constant.GeneralConstant.RIGHT_BRACKET;
import static lotto.constant.GeneralConstant.PRIZE_PRINT_ORDER;

import java.util.List;
import lotto.constant.Message;
import lotto.domain.Lotto;
import lotto.util.StringUtil;

public class OutputView {
    public static void printPurchase(int number) {
        System.out.println(String.format(Message.PURCHASE_LOTTO.toString(), number));
    }

    public static void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            printLottoNumber(lotto.getNumbers());
        }
        System.out.println();
    }

    private static void printLottoNumber(List<Integer> numbers) {
        String result = LEFT_BRACKET;
        result += StringUtil.convertListToString(numbers) + RIGHT_BRACKET;
        System.out.println(result);
    }

    public static void printPrizeStatistics(List<Integer> prizeCounts) {
        System.out.println(Message.PRIZE_STATISTICS);
        for(int i = ZERO; i < PRIZE_PRINT_ORDER.size(); i++) {
            printPrizeCount(i, prizeCounts.get(i));
        }
    }

    private static void printPrizeCount(int number, int count) {
        String order = PRIZE_PRINT_ORDER.get(number);
        System.out.println(String.format(Message.valueOf(order).toString(), count));
    }

    public static void printRateOfReturn(double rate) {
        System.out.println(String.format(Message.RATE_OF_RETURN.toString(), rate));
    }
}
