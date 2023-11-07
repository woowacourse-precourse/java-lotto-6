package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningPrize;

public class OutputView {
    private static final String LOTTO_COUNT_OF_PURCHASES_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_PRIZE_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_SECOND_PRIZE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RETURN_ON_LOTTO_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String DASH = "-";
    private static final int RESULT_DASH_COUNT = 3;
    private static final String NEW_LINE = "\n";

    public void printLottoCountOfPurchase(int lottosCount) {
        System.out.println();
        System.out.println(String.format(LOTTO_COUNT_OF_PURCHASES_FORMAT, lottosCount));
    }

    public void printLottos(List<Lotto> lottos) {
        StringBuilder result = new StringBuilder();
        lottos.forEach(lotto -> {
            List<Integer> numbers = sortNumbers(lotto.getNumbers());
            result.append(numbers)
                    .append(NEW_LINE);
        });
        System.out.println(result);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void printResult(Map<WinningPrize, Integer> winningPrizes, double ReturnOnLotto) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DASH.repeat(RESULT_DASH_COUNT));
        printWinningStatistics(winningPrizes);

        System.out.print(String.format(RETURN_ON_LOTTO_MESSAGE, ReturnOnLotto));
    }

    private void printWinningStatistics(Map<WinningPrize, Integer> winningPrizes) {
        Arrays.stream(WinningPrize.values())
                .forEach(winningPrize -> {
                    if (winningPrize == WinningPrize.EMPTY_PRIZE) {
                        return;
                    }
                    int winningPrizeCount = winningPrizes.getOrDefault(winningPrize, 0);
                    String winningPrizeMessage = generateWinningPrizeMessage(winningPrize, winningPrizeCount);
                    System.out.println(winningPrizeMessage);
                });
    }

    private String generateWinningPrizeMessage(WinningPrize winningPrize, int winningPrizeCount) {
        String messageFormat = getWinningMessageFormat(winningPrize);
        return String
                .format(
                        messageFormat,
                        winningPrize.getWinningNumbersCount(),
                        winningPrize.getWinningPrizeAmount(),
                        winningPrizeCount
                );
    }

    private String getWinningMessageFormat(WinningPrize winningPrize) {
        if (winningPrize != WinningPrize.SECOND_PRIZE) {
            return WINNING_PRIZE_MESSAGE;
        }
        return  WINNING_SECOND_PRIZE_MESSAGE;
    }
}
