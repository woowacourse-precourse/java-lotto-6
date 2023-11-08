package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.dto.response.LottoDto;
import lotto.dto.response.LottoGroupDto;
import lotto.dto.response.PrizeSummaryDto;
import lotto.dto.response.TotalProfitRateDto;
import lotto.model.LottoPrize;
import lotto.view.printer.Printer;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String LOTTO_GROUP_SIZE_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_PRIZE_RESULT_START_MESSAGE = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";
    private static final String PRIZE_MONEY_FORMAT = "%,d";
    private static final String NORMAL_PRIZE_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_PRIZE_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String TOTAL_PROFIT_RATE_FORMAT = "%,.1f";
    private static final String TOTAL_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

    private final Printer printer;

    private OutputView(Printer printer) {
        this.printer = printer;
    }

    public static OutputView from(Printer printer) {
        return new OutputView(printer);
    }

    public void printExceptionMessage(String exceptionMessage) {
        String exceptionMessageFormatted = formatExceptionMessage(exceptionMessage);
        printer.printExceptionMessage(exceptionMessageFormatted);
    }

    private String formatExceptionMessage(String exceptionMessage) {
        return String.format(EXCEPTION_FORMAT, exceptionMessage);
    }

    public void printLottoGroup(LottoGroupDto lottoGroupDto) {
        printSize(lottoGroupDto.getSize());
        printLottos(lottoGroupDto.getLottos());
        printEmptyLine();
    }

    private void printSize(int lottoGroupSize) {
        String lottoGroupSizeMessage = formatSizeMessage(lottoGroupSize);
        printer.printLine(lottoGroupSizeMessage);
    }

    private String formatSizeMessage(int lottoGroupSize) {
        return String.format(LOTTO_GROUP_SIZE_FORMAT, lottoGroupSize);
    }

    private void printLottos(List<LottoDto> lottoDtos) {
        lottoDtos.forEach(this::printLotto);
    }

    private void printLotto(LottoDto lottoDto) {
        String sortedLottoNumbersMessage = formatLottoNumbers(lottoDto);
        printer.printLine(sortedLottoNumbersMessage);
    }

    private String formatLottoNumbers(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.getSortedNumbers();
        return numbers.toString();
    }

    private void printEmptyLine() {
        printer.printEmptyLine();
    }

    public void printPrizeSummary(PrizeSummaryDto prizeSummaryDto) {
        printer.printLine(TOTAL_PRIZE_RESULT_START_MESSAGE);
        printer.printLine(LINE_SEPARATOR);
        printWinningPrizes(prizeSummaryDto);
    }

    private void printWinningPrizes(PrizeSummaryDto prizeSummaryDto) {
        Map<LottoPrize, Long> winningPrizeSummary = prizeSummaryDto.getPrizeSummary();
        winningPrizeSummary.forEach(this::printWinningPrize);
    }

    private void printWinningPrize(LottoPrize lottoPrize, Long numberOfPrizesMatched) {
        String prizeMessage = formatPrizeMessage(lottoPrize, numberOfPrizesMatched);
        printer.printLine(prizeMessage);
    }

    private String formatPrizeMessage(LottoPrize lottoPrize, Long numberOfPrizesMatched) {
        int requiredMatchingNumbers = lottoPrize.getRequiredMatchingNumbers();
        String prizeMoneyFormatted = formatPrizeMoney(lottoPrize);
        String prizeMessage = formatNormalPrizeMessage(requiredMatchingNumbers, prizeMoneyFormatted,
                numberOfPrizesMatched);

        if (lottoPrize.isSecondPrize()) {
            prizeMessage = formatSecondPrizeMessage(requiredMatchingNumbers, prizeMoneyFormatted,
                    numberOfPrizesMatched);
        }
        return prizeMessage;
    }

    private String formatPrizeMoney(LottoPrize lottoPrize) {
        int prizeMoney = lottoPrize.getPrizeMoney();
        return String.format(PRIZE_MONEY_FORMAT, prizeMoney);
    }

    private String formatNormalPrizeMessage(int requiredMatchingNumbers, String prizeMoneyFormatted,
                                            long numberOfPrizesMatched) {
        return String.format(NORMAL_PRIZE_MESSAGE_FORMAT, requiredMatchingNumbers, prizeMoneyFormatted,
                numberOfPrizesMatched);
    }

    private String formatSecondPrizeMessage(int matchCount, String prizeMoneyFormatted,
                                            long numberOfPrizesMatched) {
        return String.format(SECOND_PRIZE_MESSAGE_FORMAT, matchCount, prizeMoneyFormatted, numberOfPrizesMatched);
    }

    public void printTotalProfitRate(TotalProfitRateDto totalProfitRateDto) {
        double rawTotalProfitRate = totalProfitRateDto.getTotalProfitRate();
        String totalProfitRateFormatted = formatTotalProfitRate(rawTotalProfitRate);
        String totalProfitRateMessage = formatTotalProfitRateMessage(totalProfitRateFormatted);
        printer.printLine(totalProfitRateMessage);
    }

    private String formatTotalProfitRate(double rawTotalProfitRate) {
        return String.format(TOTAL_PROFIT_RATE_FORMAT, rawTotalProfitRate);
    }

    private String formatTotalProfitRateMessage(String totalProfitRateFormatted) {
        return String.format(TOTAL_PROFIT_RATE_MESSAGE_FORMAT, totalProfitRateFormatted);
    }
}
