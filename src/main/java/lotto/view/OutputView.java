package lotto.view;

import lotto.domain.*;
import lotto.enums.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;

public class OutputView {
    private static final int TO_PERCENT = 100;

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printNumberOfPurchasedLottoTickets(LottoPurchase lottoPurchase) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoPurchase.getNumberOfTickets());
    }

    public static void printPurchasedLottoNumbers(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printWinningResults(WinningResult winningResult) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println();
        Arrays.stream(Rank.valuesByReverseOrder()).forEach(rank -> {
            System.out.printf("%s개 일치", rank.getMatchedCount());
            if (rank.containsBonus()) System.out.print(", 보너스 볼 일치");
            System.out.printf(" (%s원) - %s개%n", formatter.format(rank.getWinningAmount()), winningResult.getCount(rank));
        });
    }

    public static void printTotalReturn(TotalWinning totalWinning) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", totalWinning.getTotalReturn() * TO_PERCENT);
    }
}