package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoResultBoard;
import lotto.LottoTickets;
import lotto.PurchaseAmount;

public class OutputView {

    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String RESULT_HEAD_LINE_MESSAGE = "당첨 통계";
    private static final String RESULT_SEPARATE_LINE_MESSAGE = "---";
    private static final String LOTTO_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String LOTTO_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RESULT_TOTAL_PROFITABILITY_PERCENT_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public void printAutoLottoTickets(final LottoTickets lottoTickets) {
        printNewLine();
        printPurchasedLottoQuantity(lottoTickets);
        printLottoTicketInfo(lottoTickets);
        printNewLine();
    }

    private void printPurchasedLottoQuantity(final LottoTickets lottoTickets) {
        print(String.format(PURCHASED_MESSAGE, lottoTickets.size()));
    }

    private void printLottoTicketInfo(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = ascendingSort(lotto).toList();
            print(numbers.toString());
        }
    }

    public void printLottoResultStatistics(
            final LottoResultBoard lottoResultBoard,
            final PurchaseAmount purchaseAmount
    ) {
        printLottoResultHeadLine();
        printLottoResultBoard(lottoResultBoard);
        printProfitabilityPercent(lottoResultBoard, purchaseAmount);
    }

    private void printLottoResultBoard(LottoResultBoard lottoResultBoard) {
        LottoRank[] sortedLottoRanks = sortLottoRank();
        printMatchCountByLottoRank(lottoResultBoard, sortedLottoRanks);
    }

    private void printMatchCountByLottoRank(LottoResultBoard lottoResultBoard, LottoRank[] lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            int matchNumber = lottoRank.getMatchNumber();
            long winningAmount = lottoRank.getWinningAmount();
            long matchCount = lottoResultBoard.findMatchCount(lottoRank);

            printMatchCountOfLottoRank(lottoRank, matchNumber, winningAmount, matchCount);
        }
    }

    private void printMatchCountOfLottoRank(LottoRank lottoRank, int matchNumber, long winningAmount, long matchCount) {
        if (lottoRank.equals(LottoRank.NONE)) {
            return;
        }
        if (lottoRank.equals(LottoRank.SECOND)) {
            print(String.format(LOTTO_BONUS_RESULT_MESSAGE, matchNumber, winningAmount, matchCount));
            return;
        }
        print(String.format(LOTTO_RESULT_MESSAGE, matchNumber, winningAmount, matchCount));
    }

    private LottoRank[] sortLottoRank() {
        LottoRank[] lottoRanks = LottoRank.values();
        Arrays.sort(lottoRanks, Collections.reverseOrder());
        return lottoRanks;
    }

    private void printProfitabilityPercent(
            final LottoResultBoard lottoResultBoard,
            final PurchaseAmount purchaseAmount
    ) {
        double roundedProfitabilityPercent = calculateRoundedProfitabilityPercent(lottoResultBoard, purchaseAmount);
        print(String.format(RESULT_TOTAL_PROFITABILITY_PERCENT_MESSAGE, roundedProfitabilityPercent));
    }

    private static double calculateRoundedProfitabilityPercent(LottoResultBoard lottoResultBoard,
                                                               PurchaseAmount purchaseAmount) {
        double profitabilityPercent = lottoResultBoard.calculateProfitabilityPercent(purchaseAmount);
        return roundProfitabilityPercent(profitabilityPercent);
    }

    private static double roundProfitabilityPercent(double profitabilityPercent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return Double.parseDouble(decimalFormat.format(profitabilityPercent));
    }

    private void printLottoResultHeadLine() {
        printNewLine();
        print(RESULT_HEAD_LINE_MESSAGE);
        print(RESULT_SEPARATE_LINE_MESSAGE);
    }

    private Stream<Integer> ascendingSort(Lotto lotto) {
        return lotto.getNumbers().stream().sorted();
    }

    public void printErrorMessage(final Exception e) {
        print(ERROR_MESSAGE + e.getMessage());
    }

    private void print(final String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
