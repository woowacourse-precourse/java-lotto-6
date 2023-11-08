package lotto.view;

import lotto.constant.InfoMessage;
import lotto.constant.MagicNumber;
import lotto.constant.StatisticsMessage;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private StringBuilder outputMessage;
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printPurchasedLotteries(List<Lotto> lotteries) {
        List<Integer> lottoTemp;
        outputMessage = new StringBuilder();
        outputMessage.append("\n").append(lotteries.size())
                .append(InfoMessage.ANNOUNCE_LOTTERIES_COUNT.getMessage()).append("\n");

        for (Lotto lotto : lotteries) {
            lottoTemp = new ArrayList<>(lotto.getNumbers());
            sortNumbers(lottoTemp);
            outputMessage.append(lottoTemp).append("\n");
        }

        outputMessage.deleteCharAt(outputMessage.length() - 1);
        System.out.println(outputMessage);
    }

    public void printWinningStatistics(List<Integer> rank) {
        System.out.println("\n" + StatisticsMessage.STATISTICS_INFO.getMessage());

        List<StatisticsMessage> messages = List.of(StatisticsMessage.values());
        for (int i = MagicNumber.RANK_COUNT.getNumber()-1; i >= 0; i--) {
            System.out.println(messages.get(i).getLottoStatisticsDescription(rank.get(i)));
        }
    }

    public void printProfitPercentage(double profitPercentage) {
        System.out.println(InfoMessage.ANNOUNCE_TOTAL_PROFIT_START.getMessage()
                + String.format("%.1f", profitPercentage) + InfoMessage.ANNOUNCE_TOTAL_PROFIT_END.getMessage());
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
