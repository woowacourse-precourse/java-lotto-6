package lotto.view;

import lotto.domain.LottoRanking;
import lotto.dto.LottoDto;

import java.util.List;
import java.util.Map;

public class OutputView {
    protected static final String NEWLINE = System.lineSeparator();

    private static final String NUMBER_OF_LOTTOS_MESSAGE_FORMAT = "%d개를 구매했습니다." + NEWLINE;
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String RATE_OF_RETURN_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s" + NEWLINE;

    public void printLottos(List<LottoDto> lottos) {
        newLine();
        printLottoCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private void newLine() {
        System.out.println();
    }

    private void printLottoCount(int size) {
        System.out.printf(NUMBER_OF_LOTTOS_MESSAGE_FORMAT, size);
    }

    private void printLottoNumbers(List<LottoDto> lottos) {
        StringBuilder numbersMessageBuilder = new StringBuilder();

        for (LottoDto lotto : lottos) {
            numbersMessageBuilder.append(lotto.numbers())
                    .append(NEWLINE);
        }

        System.out.println(numbersMessageBuilder);
    }

    public void printLottoResult(Map<LottoRanking, Integer> result, double rateOfReturn) {
        printWinningStatistics(result);
        printRateOfResult(rateOfReturn);
    }

    private void printWinningStatistics(Map<LottoRanking, Integer> result) {
        newLine();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(MessageGenerator.generateStatisticsMessage(result));
    }

    public void printRateOfResult(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE_FORMAT, rateOfReturn);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}
