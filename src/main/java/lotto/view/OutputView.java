package lotto.view;

import static java.util.stream.Collectors.joining;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.WinningRanking;
import lotto.dto.LotteriesDto;
import lotto.dto.LottoDto;
import lotto.dto.WinningStatisticsDto;

public class OutputView {

    private static final String LOTTO_SIZE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String NUMBER_DELIMITER = ", ";
    private static final String NUMBER_PREFIX = "[";
    private static final String NUMBER_SUFFIX = "]\n";

    private static final String WINNING_STATISTICS_TITLE = """
                        
            당첨 통계
            ---
            """;
    private static final String WINNING_RANKING_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_RANKING_BONUS_MATCHED_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %s%%입니다.\n";
    private static final List<WinningRanking> OUTPUT_ORDER_OF_RANKING = List.of(WinningRanking.FIFTH,
            WinningRanking.FOURTH, WinningRanking.THIRD, WinningRanking.SECOND, WinningRanking.FIRST);
    private static final DecimalFormat NUMBER_FORMATTER = new DecimalFormat("###,###.#");
    private static final int NOT_EXIST = 0;

    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";

    public void printLotteries(LotteriesDto lotteries) {
        printCountOfLotteries(lotteries.getSize());
        lotteries.lottos().forEach(this::printLotto);
    }

    private void printCountOfLotteries(int size) {
        print(LOTTO_SIZE_FORMAT.formatted(size));
    }

    private void printLotto(LottoDto lottoDto) {
        String message = makeLottoView(lottoDto);
        print(message);
    }

    private String makeLottoView(LottoDto lottoDto) {
        return lottoDto.numbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(joining(NUMBER_DELIMITER, NUMBER_PREFIX, NUMBER_SUFFIX));
    }

    public void printWinningStatistics(WinningStatisticsDto winningStatistics) {
        print(WINNING_STATISTICS_TITLE);
        printStatisticsByOrderedRanking(winningStatistics);
        printRateOfReturn(winningStatistics.getRateOfReturnPercentage());
    }

    private void printStatisticsByOrderedRanking(WinningStatisticsDto winningStatistics) {
        for (WinningRanking ranking : OUTPUT_ORDER_OF_RANKING) {
            int count = winningStatistics.countOfRanking().getOrDefault(ranking, NOT_EXIST);
            String message = makeRankingView(ranking, count);
            print(message);
        }
    }

    private String makeRankingView(WinningRanking ranking, int count) {
        if (ranking.isBonusCorrect()) {
            return WINNING_RANKING_BONUS_MATCHED_FORMAT
                    .formatted(ranking.getCountOfCorrect(), toPrintedNumber(ranking.getPrice()), count);
        }
        return WINNING_RANKING_FORMAT
                .formatted(ranking.getCountOfCorrect(), toPrintedNumber(ranking.getPrice()), count);
    }

    private void printRateOfReturn(double ratePercentage) {
        String printedRate = toPrintedNumber(ratePercentage);
        String message = RATE_OF_RETURN_FORMAT.formatted(printedRate);
        print(message);
    }

    private String toPrintedNumber(long number) {
        return NUMBER_FORMATTER.format(number);
    }

    private String toPrintedNumber(double number) {
        return NUMBER_FORMATTER.format(number);
    }

    public void printExceptionMessage(Exception exception) {
        String message = makeExceptionView(exception);
        print(message);
    }

    private String makeExceptionView(Exception exception) {
        return EXCEPTION_MESSAGE_FORMAT.formatted(exception.getMessage());
    }

    private void print(String message) {
        System.out.print(message);
    }
}
