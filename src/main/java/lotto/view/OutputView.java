package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    protected static final String NEWLINE = System.lineSeparator();

    private static final String NUMBER_OF_LOTTOS_MESSAGE_FORMAT = "%d개를 구매했습니다." + NEWLINE;
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String RATE_OF_RETURN_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s" + NEWLINE;
    private static final String RATE_OF_RETURN_FORMAT_PATTERN = "###,##0.0";

    private final MessageGenerator messageGenerator;

    public OutputView(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

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

    public void printLottoResult(LottoResultDto lottoResult, double rateOfReturn) {
        printWinningStatistics(lottoResult);
        printRateOfReturn(rateOfReturn);
    }

    private void printWinningStatistics(LottoResultDto lottoResult) {
        newLine();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(messageGenerator.generateStatisticsMessage(lottoResult.result()));
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE_FORMAT, generateRateOfReturnMessage(rateOfReturn));
    }

    private String generateRateOfReturnMessage(double rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat(RATE_OF_RETURN_FORMAT_PATTERN);
        return decimalFormat.format(rateOfReturn);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}
