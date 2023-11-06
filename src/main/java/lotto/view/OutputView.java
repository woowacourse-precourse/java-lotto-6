package lotto.view;

import java.util.List;
import lotto.dto.response.LottoDto;
import lotto.dto.response.LottoGroupDto;
import lotto.dto.response.TotalProfitRateDto;
import lotto.model.LottoPrize;
import lotto.model.PrizeSummary;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String LOTTO_GROUP_SIZE_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_PRIZE_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String PRIZE_AMOUNT_FORMAT = "%,d";
    private static final String NORMAL_PRIZE_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_PRIZE_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String TOTAL_PROFIT_RATE_FORMAT = "%,.1f";
    private static final String TOTAL_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printExceptionMessage(String exceptionMessage) {
        String formattedExceptionMessage = String.format(EXCEPTION_FORMAT, exceptionMessage);
        println(formattedExceptionMessage);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printLottoGroup(LottoGroupDto lottoGroupDto) {
        printSize(lottoGroupDto.getSize());
        printLottos(lottoGroupDto.getLottos());
        printEmptyLine();
    }

    private void printSize(int lottoGroupSize) {
        String message = String.format(LOTTO_GROUP_SIZE_FORMAT, lottoGroupSize);
        println(message);
    }

    private void printLottos(List<LottoDto> lottos) {
        lottos.forEach(this::printLotto);
    }

    private void printLotto(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.getSortedNumbers();
        String formattedSortedLottoNumbers = numbers.toString();
        println(formattedSortedLottoNumbers);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printTotalProfitRate(TotalProfitRateDto totalProfitRate) {
        double rawTotalProfitRate = totalProfitRate.getTotalProfitRate();
        String totalProfitRateFormatted = String.format(TOTAL_PROFIT_RATE_FORMAT, rawTotalProfitRate);
        String totalProfitRateMessage = String.format(TOTAL_PROFIT_RATE_MESSAGE_FORMAT, totalProfitRateFormatted);
        println(totalProfitRateMessage);
    }

    public void printPrizeSummary(PrizeSummary prizeSummary) {
        println(TOTAL_PRIZE_RESULT_MESSAGE);
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
        println(prizeMessage);
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

    private static String formatSecondPrizeMessage(int matchCount, String formattedPrizeAmount, long prizeCount) {
        return String.format(SECOND_PRIZE_MESSAGE_FORMAT, matchCount, formattedPrizeAmount, prizeCount);
    }

    private static String formatNormalPrizeMessage(int matchCount, String formattedPrizeAmount, long prizeCount) {
        return String.format(NORMAL_PRIZE_MESSAGE_FORMAT, matchCount, formattedPrizeAmount, prizeCount);
    }

    private static String formatPrizeAmount(LottoPrize lottoPrize) {
        int prizeAmount = lottoPrize.getPrizeMoney();
        return String.format(PRIZE_AMOUNT_FORMAT, prizeAmount);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }
}
