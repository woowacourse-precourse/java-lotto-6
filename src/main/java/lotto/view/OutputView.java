package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.text.MessageFormat.format;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";
    private static final String PRINT_LOTTO_SIZE_FORMAT = "\n{0}개를 구매했습니다.";
    private static final String PRINT_LOTTO_RESULT_START_FORMAT = "\n당첨 통계\n---\n";
    private static final String PRINT_PRIZE_RESULT_FORMAT = "{0}개 일치 ({1}원) - {2}개\n";
    private static final String PRINT_2ND_PRIZE_RESULT_FORMAT = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개\n";
    private static final String PRINT_RATE_RETURN_FORMAT = "총 수익률은 {0}%입니다.";
    private static final int ZERO = 0;

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    public void printLottoTicket(List<Lotto> lottoTicket) {
        System.out.println(format(PRINT_LOTTO_SIZE_FORMAT, lottoTicket.size()));
        IntStream.range(ZERO, lottoTicket.size())
                .forEach(i -> System.out.println(lottoTicket.get(i)));
    }

    public void printLottoResult(EnumMap<LottoPrize, Integer> lottoResult) {
        lottoResult.remove(LottoPrize.NOTHING);
        StringBuilder winningStatistics = new StringBuilder();
        winningStatistics.append(PRINT_LOTTO_RESULT_START_FORMAT);
        lottoResult.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(prize -> lottoResultFormat(winningStatistics, prize, lottoResult.get(prize)));
        System.out.print(winningStatistics);
    }

    public void printReturnRate(double returnRate) {
        System.out.println(format(PRINT_RATE_RETURN_FORMAT, returnRate));
    }

    private void lottoResultFormat(StringBuilder winningStatistics, LottoPrize prize, int numberOfWin) {
        int prizeMatchingCount = prize.getMatchingCount();
        String prizeMoney = prize.getPrize().getMoneyPrintFormat();

        if (prize == LottoPrize.PRIZE_2ND) {
            winningStatistics.append(
                    format(PRINT_2ND_PRIZE_RESULT_FORMAT,
                            prizeMatchingCount, prizeMoney, numberOfWin));
            return;
        }
        winningStatistics.append(
                format(PRINT_PRIZE_RESULT_FORMAT,
                        prizeMatchingCount, prizeMoney, numberOfWin));
    }
}
