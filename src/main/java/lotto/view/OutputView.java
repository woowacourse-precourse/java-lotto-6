package lotto.view;

import java.util.List;
import lotto.dto.response.LottoDto;
import lotto.dto.response.LottoGroupDto;
import lotto.model.LottoPrize;
import lotto.model.TotalPrize;
import lotto.model.TotalProfit;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String LOTTO_GROUP_SIZE_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_PRIZE_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String PRIZE_AMOUNT_FORMAT = "%,d";
    private static final String NORMAL_PRIZE_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_PRIZE_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String TOTAL_PROFIT_FORMAT = "%,.1f";
    private static final String TOTAL_PROFIT_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

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

    public void printTotalProfit(TotalProfit totalProfit) {
        double rawTotalProfit = totalProfit.getTotalProfit();
        String formattedTotalProfit = String.format(TOTAL_PROFIT_FORMAT, rawTotalProfit);
        String message = String.format(TOTAL_PROFIT_MESSAGE_FORMAT, formattedTotalProfit);
        println(message);
    }

    public void printTotalPrize(TotalPrize totalPrize) {
        println(TOTAL_PRIZE_RESULT_MESSAGE);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            printWinningPrize(totalPrize, lottoPrize);
        }
    }

    private void printWinningPrize(TotalPrize totalPrize, LottoPrize lottoPrize) {
        if (lottoPrize.isWinningPrize()) {
            printPrize(totalPrize, lottoPrize);
        }
    }

    private void printPrize(TotalPrize totalPrize, LottoPrize lottoPrize) {
        int matchCount = lottoPrize.getRequiredMatchingNumbers();
        String formattedPrizeAmount = formattingPrizeAmount(lottoPrize);
        long prizeCount = totalPrize.countMatchesForPrize(lottoPrize);
        String message = formattingNormalPrizeMessage(matchCount, formattedPrizeAmount, prizeCount);
        if (lottoPrize.isSecondPrize()) {
            message = formattingSecondPrizeMessage(matchCount, formattedPrizeAmount, prizeCount);
        }
        println(message);
    }

    private static String formattingSecondPrizeMessage(int matchCount, String formattedPrizeAmount, long prizeCount) {
        return String.format(SECOND_PRIZE_MESSAGE_FORMAT, matchCount, formattedPrizeAmount, prizeCount);
    }

    private static String formattingNormalPrizeMessage(int matchCount, String formattedPrizeAmount, long prizeCount) {
        return String.format(NORMAL_PRIZE_MESSAGE_FORMAT, matchCount, formattedPrizeAmount, prizeCount);
    }

    private static String formattingPrizeAmount(LottoPrize lottoPrize) {
        int prizeAmount = lottoPrize.getPrizeMoney();
        return String.format(PRIZE_AMOUNT_FORMAT, prizeAmount);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
