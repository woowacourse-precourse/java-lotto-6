package lotto.view;

import lotto.dto.response.PurchasePriceResponse;
import lotto.dto.response.WinningResponse;
import lotto.dto.response.WinningStatistic;
import java.util.List;
import java.util.Map;

import static lotto.configuration.GameConfiguration.DECIMAL_REGEX;
import static lotto.configuration.GameConfiguration.DECIMAL_SEPARATOR;
import static lotto.configuration.GameConfiguration.REQUIRED_BONUS_NUMBER_RANK;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printPurchasePriceQuestionMessage() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    @Override
    public void printWinningNumberQuestionMessage() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    @Override
    public void printBonusNumberQuestionMessage() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    @Override
    public void printPurchaseLottos(final List<PurchasePriceResponse> purchasePriceResponses) {
        System.out.println();
        System.out.println(String.format(PURCHASE_LOTTO_COUNT_FORMAT, purchasePriceResponses.size()));
        for (PurchasePriceResponse purchasePriceResponse : purchasePriceResponses) {
            final List<Integer> numbers = purchasePriceResponse.getNumbers();
            System.out.println(numbers);
        }
    }

    @Override
    public void printWinningStatistic(final WinningResponse winningResponse) {
        printWinningStatisticPrefix();

        final Map<Integer, WinningStatistic> countGroupingByRank = winningResponse.getStatisticGroupingByRank();
        final double profitRate = winningResponse.getProfitRate();
        final List<Integer> descendingOrderedKeys = getDescendingOrderedKeys(countGroupingByRank);

        printWinningStatistic(countGroupingByRank, descendingOrderedKeys);
        printProfitRate(profitRate);
    }

    private void printWinningStatisticPrefix() {
        System.out.println();
        System.out.println(WINNING_RESULT_MESSAGE_PREFIX);
        System.out.println(WINNING_RESULT_SEPARATE_LINE);
    }

    private List<Integer> getDescendingOrderedKeys(final Map<Integer, WinningStatistic> countGroupingByRank) {
        return countGroupingByRank.keySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b, a))
                .toList();
    }

    private String createResultFormat(final int rank) {
        final StringBuilder sb = new StringBuilder(MATCH_COUNT_FORMAT);
        if (rank == REQUIRED_BONUS_NUMBER_RANK) {
            sb.append(MATCH_BONUS_BALL_MESSAGE);
        }

        sb.append(WINNING_PRICE_COUNT_FORMAT);
        return sb.toString();
    }

    private void printWinningStatistic(final Map<Integer, WinningStatistic> countGroupingByRank,
                                              final List<Integer> descendingOrderedKeys) {
        for (int rank : descendingOrderedKeys) {
            final String resultFormat = createResultFormat(rank);
            final WinningStatistic winningStatistic = countGroupingByRank.get(rank);
            final String decimalAmount = getDecimalAmount(winningStatistic.getAmount());
            System.out.println(String.format(resultFormat, winningStatistic.getMatchedCount(), decimalAmount, winningStatistic.getCount()));
        }
    }

    private String getDecimalAmount(final long amount) {
        return String.valueOf(amount)
                .replaceAll(DECIMAL_REGEX, DECIMAL_SEPARATOR);
    }

    private void printProfitRate(final double profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
