package View;

import static util.LottoRankNumber.FIFTH;
import static util.LottoRankNumber.FIRST;
import static util.LottoRankNumber.SECOND;
import static util.LottoValidationValue.LOTTO_PRICE;
import static util.ProgressMessage.OUTPUT_BUY_NUMBER;
import static util.RoundingOff.SECOND_DECIMAL;
import static util.WinningStatisticsMessage.BAR;
import static util.WinningStatisticsMessage.COUNT_RANK;
import static util.WinningStatisticsMessage.COUNT_RANK_WITH_BONUS;
import static util.WinningStatisticsMessage.FORMAT_WITH_COMMA;
import static util.WinningStatisticsMessage.RATE_OF_RETURN;
import static util.WinningStatisticsMessage.RESULT_START;

import domain.Amount;
import domain.Lottos;
import domain.Rank;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import service.EnumToList;

public class OuputView {

    public static void buyMessage(Amount amount) {
        amount.printAmount();
        System.out.println(OUTPUT_BUY_NUMBER.get());
    }

    public static void lottosNumbers(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void lottosResult(Amount amount, Rank rank) {
        Map<Integer, Integer> rankCount = rank.count();
        List<Integer> price = EnumToList.lottoWiningPriceToList();
        List<Integer> rankNumber = EnumToList.lottoRankNumberToList();

        System.out.println(RESULT_START.get());
        System.out.println(BAR.get());
        showNumberByRank(rankCount, price, rankNumber);
        showRateOfReturn(rankCount, price, rankNumber, amount);
    }

    private static void showNumberByRank(Map<Integer, Integer> rankCount, List<Integer> price,
                                         List<Integer> rankNumber) {

        List<Integer> equalNumber = EnumToList.equalNumberAccordRankToList();

        for (int i = FIFTH.get(); i >= FIRST.get(); i--) {
            if (i != SECOND.get()) {
                System.out.printf(COUNT_RANK.get(),
                        equalNumber.get(i - 1), formatByDecimal(price.get(i - 1)),
                        rankCount.get(rankNumber.get(i - 1)));
                continue;
            }
            System.out.printf(COUNT_RANK_WITH_BONUS.get(),
                    equalNumber.get(i - 1), formatByDecimal(price.get(i - 1)), rankCount.get(rankNumber.get(i - 1)));
        }
    }

    private static void showRateOfReturn(Map<Integer, Integer> rankCount, List<Integer> price, List<Integer> rankNumber,
                                         Amount amount) {
        int revenue = 0;

        for (int i = FIFTH.get(); i >= FIRST.get(); i--) {
            revenue += price.get(i - 1) * rankCount.get(rankNumber.get(i - 1));
        }
        System.out.printf(RATE_OF_RETURN.get(), calculateRateOfReturn(revenue, amount));
    }

    private static String formatByDecimal(int value) {
        DecimalFormat decFormat = new DecimalFormat(FORMAT_WITH_COMMA.get());
        return decFormat.format(value);
    }

    private static double calculateRateOfReturn(int revenue, Amount amount) {
        double result = (double) revenue / (amount.getAmount() * LOTTO_PRICE.get());
        return Math.round(result * SECOND_DECIMAL.get()) / SECOND_DECIMAL.get();
    }
}
