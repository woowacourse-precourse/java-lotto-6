package lotto.view;

import lotto.constant.LottoWinningRank;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoWinningResult;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private static final String PRINT_BOUGHT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_BOUGHT_LOTTO_NUMBER_START_BOX = "[";
    private static final String PRINT_BOUGHT_LOTTO_NUMBER_END_BOX = "]";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String PRINT_LOTTO_WINNING_STATISTICS_TITLE_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_EQUAL_NUMBER_COUNT_MESSAGE = "개 일치";
    private static final String PRINT_HAS_BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    private static final String PRINT_WINNING_AMOUNT_MESSAGE = " (%s원)";
    private static final String PRINT_WINNING_LOTTO_COUNT_MESSAGE = " - %d개";
    private static final String PRINT_TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FORMAT + errorMessage);
    }

    public static void printBuyLottoResultMessage(List<LottoNumbers> lottoNumbers) {
        printBuyLottoCount(lottoNumbers.size());
        lottoNumbers.forEach(numbers -> printLottoNumbers(numbers.numbers()));
    }

    private static void printBuyLottoCount(int buyLottoCount) {
        System.out.println(buyLottoCount + PRINT_BOUGHT_LOTTO_COUNT_MESSAGE);
    }

    private static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.print(PRINT_BOUGHT_LOTTO_NUMBER_START_BOX
                + convertNumberToOutputValue(lottoNumbers)
                + PRINT_BOUGHT_LOTTO_NUMBER_END_BOX
        );
        System.out.println();
    }

    private static String convertNumberToOutputValue(List<Integer> numbers) {
        Collections.sort(new ArrayList<>(numbers));
        List<String> convertValues = numbers.stream()
                .map(String::valueOf)
                .toList();

        return String.join(LOTTO_NUMBERS_DELIMITER, convertValues);
    }

    public static void printLottoWinningResult(LottoWinningResult result) {
        System.out.println(PRINT_LOTTO_WINNING_STATISTICS_TITLE_MESSAGE);
        printLottoWinningStatistics(result.winningRanks());
        printTotalReturnRate(result.totalReturnRate());
    }

    private static void printLottoWinningStatistics(List<LottoWinningRank> inputRanks) {
        List<LottoWinningRank> lottoWinningRanks = getLottoWinningRanks();
        lottoWinningRanks.forEach(rank -> {
            printLottoWinningCondition(rank.getMatchingNumberCount(), rank.isBonusNumberMatched());
            printWinningAmount(rank.getWinningAmount());
            printWinningLottoCount(Collections.frequency(inputRanks, rank));
            System.out.println();
        });
    }

    private static List<LottoWinningRank> getLottoWinningRanks() {
        List<LottoWinningRank> lottoWinningRanksIgnoreNoLuck = LottoWinningRank.getLottoWinningRanksIgnoreNoLuck();
        Collections.reverse(lottoWinningRanksIgnoreNoLuck);

        return lottoWinningRanksIgnoreNoLuck;
    }

    private static void printLottoWinningCondition(int equalNumberCount, boolean hasBonusNumber) {
        String message = equalNumberCount + PRINT_EQUAL_NUMBER_COUNT_MESSAGE;
        if (hasBonusNumber) {
            message += PRINT_HAS_BONUS_NUMBER_MESSAGE;
        }

        System.out.print(message);
    }

    private static void printWinningAmount(int winningAmount) {
        String formattedWinningAmount = NumberFormat.getInstance().format(winningAmount);
        System.out.printf(PRINT_WINNING_AMOUNT_MESSAGE, formattedWinningAmount);
    }

    private static void printWinningLottoCount(int winningLottoCount) {
        System.out.printf(PRINT_WINNING_LOTTO_COUNT_MESSAGE, winningLottoCount);
    }

    private static void printTotalReturnRate(double totalReturnRate) {
        System.out.printf(PRINT_TOTAL_RETURN_RATE_MESSAGE, totalReturnRate);
    }
}
