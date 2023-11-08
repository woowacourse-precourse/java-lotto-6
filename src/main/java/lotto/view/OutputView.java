package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.PurchaseAmount;
import lotto.domain.lottoResult.LottoRank;
import lotto.domain.lottoResult.LottoResultBoard;
import lotto.domain.lottoTicket.Lotto;
import lotto.domain.lottoTicket.LottoTickets;

public class OutputView {

    public void printAutoLottoTickets(final LottoTickets lottoTickets) {
        printNewLine();
        printPurchasedLottoQuantity(lottoTickets);
        printLottoTicketInfo(lottoTickets);
        printNewLine();
    }

    private void printPurchasedLottoQuantity(final LottoTickets lottoTickets) {
        print(String.format(Message.PURCHASED_MESSAGE.getMessage(), lottoTickets.size()));
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
            print(String.format(Message.LOTTO_BONUS_RESULT_MESSAGE.getMessage(), matchNumber, winningAmount,
                    matchCount));
            return;
        }
        print(String.format(Message.LOTTO_RESULT_MESSAGE.getMessage(), matchNumber, winningAmount, matchCount));
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
        print(String.format(
                Message.RESULT_TOTAL_PROFITABILITY_PERCENT_MESSAGE.getMessage(),
                roundedProfitabilityPercent)
        );
    }

    private static double calculateRoundedProfitabilityPercent(LottoResultBoard lottoResultBoard,
                                                               PurchaseAmount purchaseAmount) {
        double profitabilityPercent = lottoResultBoard.calculateProfitabilityPercent(purchaseAmount);
        return roundProfitabilityPercent(profitabilityPercent);
    }

    private static double roundProfitabilityPercent(double profitabilityPercent) {
        DecimalFormat decimalFormat = new DecimalFormat(Message.DECIMAL_PATTERN.getMessage());
        return Double.parseDouble(decimalFormat.format(profitabilityPercent));
    }

    private void printLottoResultHeadLine() {
        printNewLine();
        print(Message.RESULT_HEAD_LINE_MESSAGE.getMessage());
        print(Message.RESULT_SEPARATE_LINE_MESSAGE.getMessage());
    }

    private Stream<Integer> ascendingSort(Lotto lotto) {
        return lotto.getNumbers().stream().sorted();
    }

    public void printErrorMessage(final Exception e) {
        print(Message.ERROR_MESSAGE.getMessage() + e.getMessage());
    }

    private void print(final String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
