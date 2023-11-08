package lotto.view;

import java.util.List;
import lotto.dto.response.LottoDto;
import lotto.dto.response.LottoGroupDto;
import lotto.dto.response.TotalProfitRateDto;
import lotto.model.LottoPrize;
import lotto.model.PrizeSummary;
import lotto.view.printer.Printer;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String LOTTO_GROUP_SIZE_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_PRIZE_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String PRIZE_AMOUNT_FORMAT = "%,d";
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

    private static String formatExceptionMessage(String exceptionMessage) {
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

    private static String formatSizeMessage(int lottoGroupSize) {
        return String.format(LOTTO_GROUP_SIZE_FORMAT, lottoGroupSize);
    }

    private void printLottos(List<LottoDto> lottoDtos) {
        lottoDtos.forEach(this::printLotto);
    }

    private void printLotto(LottoDto lottoDto) {
        String sortedLottoNumbersMessage = formatLottoNumbers(lottoDto);
        printer.printLine(sortedLottoNumbersMessage);
    }

    private static String formatLottoNumbers(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.getSortedNumbers();
        return numbers.toString();
    }

    private void printEmptyLine() {
        printer.printEmptyLine();
    }

    public void printTotalProfitRate(TotalProfitRateDto totalProfitRateDto) {
        double rawTotalProfitRate = totalProfitRateDto.getTotalProfitRate();
        String totalProfitRateFormatted = formatTotalProfitRate(rawTotalProfitRate);
        String totalProfitRateMessage = formatTotalProfitRateMessage(totalProfitRateFormatted);
        printer.printLine(totalProfitRateMessage);
    }

    private static String formatTotalProfitRate(double rawTotalProfitRate) {
        return String.format(TOTAL_PROFIT_RATE_FORMAT, rawTotalProfitRate);
    }

    private static String formatTotalProfitRateMessage(String totalProfitRateFormatted) {
        return String.format(TOTAL_PROFIT_RATE_MESSAGE_FORMAT, totalProfitRateFormatted);
    }

    public void printPrizeSummary(PrizeSummary prizeSummary) {
        printer.printLine(TOTAL_PRIZE_RESULT_MESSAGE);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            printWinningPrize(prizeSummary, lottoPrize);
        }
    }

    private void printWinningPrize(PrizeSummary prizeSummary, LottoPrize lottoPrize) {
        if (lottoPrize.isWinningPrize()) {
            printPrize(prizeSummary, lottoPrize);
        }
    }

    private void printPrize(PrizeSummary prizeSummary, LottoPrize lottoPrize) {
        String prizeMessage = formatPrizeMessage(prizeSummary, lottoPrize);
        printer.printLine(prizeMessage);
    }

    private static String formatPrizeMessage(PrizeSummary prizeSummary, LottoPrize lottoPrize) {
        int numberOfRequiredMatches = lottoPrize.getRequiredMatchingNumbers();
        String prizeAmountFormatted = formatPrizeAmount(lottoPrize);
        long numberOfPrizesMatched = prizeSummary.getMatchCountForPrize(lottoPrize);
        String prizeMessage = formatNormalPrizeMessage(numberOfRequiredMatches, prizeAmountFormatted,
                numberOfPrizesMatched);

        if (lottoPrize.isSecondPrize()) {
            prizeMessage = formatSecondPrizeMessage(numberOfRequiredMatches, prizeAmountFormatted,
                    numberOfPrizesMatched);
        }
        return prizeMessage;
    }

    private static String formatPrizeAmount(LottoPrize lottoPrize) {
        int prizeAmount = lottoPrize.getPrizeMoney();
        return String.format(PRIZE_AMOUNT_FORMAT, prizeAmount);
    }

    private static String formatNormalPrizeMessage(int matchCount, String formattedPrizeAmount, long prizeCount) {
        return String.format(NORMAL_PRIZE_MESSAGE_FORMAT, matchCount, formattedPrizeAmount, prizeCount);
    }

    private static String formatSecondPrizeMessage(int matchCount, String formattedPrizeAmount, long prizeCount) {
        return String.format(SECOND_PRIZE_MESSAGE_FORMAT, matchCount, formattedPrizeAmount, prizeCount);
    }

}
