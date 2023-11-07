package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.WinningPrize;

public class OutputView {
    private static final String LOTTO_COUNT_OF_PURCHASES_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_PRIZE_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_SECOND_PRIZE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RETURN_ON_LOTTO_MESSAGE = "총 수익률은 %.1f입니다.";
    private static final String DASH = "-";
    private static final int RESULT_DASH_COUNT = 3;

    public void printLottoCountOfPurchase(int lottosCount) {
        System.out.println(String.format(LOTTO_COUNT_OF_PURCHASES_FORMAT, lottosCount));
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void printResult(Map<WinningPrize, Integer> winningPrizes, double ReturnOnLotto) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DASH.repeat(RESULT_DASH_COUNT));

        Arrays.stream(WinningPrize.values())
                .forEach(winningPrize -> {
                    if (winningPrize == WinningPrize.EMPTY_PRIZE) {
                        return;
                    }
                    String messageFormat = WINNING_PRIZE_MESSAGE;
                    if (winningPrize == WinningPrize.SECOND_PRIZE) {
                        messageFormat = WINNING_SECOND_PRIZE_MESSAGE;
                    }

                    String message = String
                            .format(
                                    messageFormat,
                                    winningPrize.getWinningNumbersCount(),
                                    winningPrize.getWinningPrizeAmount(),
                                    winningPrizes.getOrDefault(winningPrize, 0)
                            );
                    System.out.println(message);
                });

        System.out.println(String.format(RETURN_ON_LOTTO_MESSAGE, ReturnOnLotto));
    }
}
