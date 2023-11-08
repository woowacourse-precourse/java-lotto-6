package console;

import consts.ConsoleMessage;
import consts.Rank;
import lotto.Lotto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Output {
    private Output() {
    }

    public static Output create() {
        return new Output();
    }

    public void askPurchaseAmount() {
        System.out.println(ConsoleMessage.ASK_PURCHASE_AMOUNT);
    }

    public void showPurchasedLotto(final int count, final List<Lotto> lottoNumbers) {
        this.printNewLine();
        System.out.println(String.format(ConsoleMessage.PURCHASED_LOTTO_COUNT, count));
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getStringNumbers()));
    }

    public void askWinningNumber() {
        this.printNewLine();
        System.out.println(ConsoleMessage.ASK_WINNING_NUMBER);
    }

    public void askBonusNumber() {
        this.printNewLine();
        System.out.println(ConsoleMessage.ASK_BONUS_NUMBER);
    }

    public void showWinningStatistics(final Map<Rank, Integer> results, final double profitRate) {
        this.printNewLine();
        System.out.println(ConsoleMessage.WINNING_STATISTICS);

        Rank.getRanks().stream()
                .forEach(rank -> this.printRank(rank, Objects.requireNonNullElse(results.get(rank), 0)));

        System.out.println(String.format(ConsoleMessage.WINNING_STATISTICS_PROFIT_RATE, profitRate));
    }

    public void showErrorMessage(final String message) {
        System.out.println(String.format(ConsoleMessage.ERROR_MESSAGE, message));
        this.printNewLine();
    }

    private void printRank(final Rank rank, final int count) {
        String format = ConsoleMessage.WINNING_STATISTICS_FORMAT;
        if (rank == Rank.SECOND) {
            format = ConsoleMessage.WINNING_STATISTICS_BONUS_FORMAT;
        }
        System.out.println(String.format(format, rank.getMatchCount(), formatMoney(rank.getWinningMoney()), count));
    }

    private void printNewLine() {
        System.out.println();
    }

    private String formatMoney(final int money) {
        return String.format("%,d", money);
    }
}
