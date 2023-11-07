package lotto.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.service.ReturnRateCalculator;
import lotto.service.TotalStatCalculator;
import lotto.util.OutputMessage;

public class OutputController {
    private TotalStatCalculator totalStatCalculator;

    public OutputController(TotalStatCalculator totalStatCalculator) {
        this.totalStatCalculator = totalStatCalculator;
    }

    public void printLottoPapers(List<Lotto> lottos, int lottoCount) {
        System.out.println();
        System.out.println(String.format(OutputMessage.LOTTO_PRINT_TITLE.toString(), lottoCount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(int customerPrice) {
        Map<String, Integer> winningStatistics = totalStatCalculator.getTotalLottoStats();
        String returnRate = ReturnRateCalculator.getReturnRate(winningStatistics, customerPrice);

        System.out.println();
        System.out.println(OutputMessage.TOTAL_STATISTICS_TITLE);
        System.out.println(OutputMessage.TOTAL_PARAMETER);
        for (String message : getMessages(winningStatistics, false)) {
            System.out.println(String.format(OutputMessage.TOTAL_STATISTICS_MESSAGE.toString(), message,
                    winningStatistics.get(message)));
        }
        System.out.println(String.format(OutputMessage.TOTAL_RETURN_VALUE_MESSAGE.toString(), returnRate));
    }

    public static List<String> getMessages(Map<String, Integer> winningStatistics, boolean isReverse) {
        if (isReverse) {
            return winningStatistics.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
        return winningStatistics.keySet().stream().sorted().collect(Collectors.toList());
    }
}
