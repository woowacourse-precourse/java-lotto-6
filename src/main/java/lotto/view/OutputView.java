package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Prize;

public class OutputView {
    private static final String WINNING_STATISTICS_FORMAT = "%s %d개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public void displayticket(int ticket) {
        System.out.println(ticket + "개를 구매했습니다.");
    }

    public void displayLottosNumber(List<List<Integer>> lottosNumber) {
        for (List<Integer> numbers : lottosNumber) {
            System.out.println(numbers);
        }
    }

    public void displayWinningStatistics(Map<Prize, Integer> prizeCountMap) {
        Prize[] orderedPrizes = {Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST};

        for (Prize prize : orderedPrizes) {
            System.out.printf(WINNING_STATISTICS_FORMAT,
                    prize.getMessage().getMessage(),
                    prizeCountMap.getOrDefault(prize, 0));
            System.out.println();
        }
    }



    public void displayEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE, earningRate);
        ConsoleOutput.printNewLine();
    }
}
