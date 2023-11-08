package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public abstract class ResultView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");

    public abstract void println(final String text);

    public void printException(final Exception exception) {
        println(ERROR_PREFIX + exception.getMessage());
    }

    public void displayPurchasedLottos(final List<Lotto> purchasedLottos) {
        println(String.format("%n%d개를 구매했습니다.", purchasedLottos.size()));
        purchasedLottos.stream()
                .map(Lotto::formatNumbers)
                .forEach(this::println);
    }

    public void displayRankCount(final Rank rank, int count) {
        if (rank == Rank.NONE) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount())
                .append("개 일치");

        if (rank.isMatchBonus()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (")
                .append(DECIMAL_FORMAT.format(rank.getPrizeMoney()))
                .append("원) - ")
                .append(count)
                .append("개");

        println(sb.toString());
    }

    public void displayProfitRate(final long totalPrizeMoney, final int totalPurchaseAmount) {
        double profitRate = (double) totalPrizeMoney / totalPurchaseAmount / 10;
        println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }
}
