package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.Rank;

import java.util.Map;

import static lotto.util.Constants.LOTTO_AMOUNT;
import static lotto.util.GameMessage.*;

public class OutputView {

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + PURCHASE_MESSAGE.getMessage());
    }

    public static void printLottoNumbers(Lottos lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static int printResult(Map<Rank, Integer> winningCounts) {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println("---");

        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> rank : winningCounts.entrySet()) {
            Rank lottoRank = rank.getKey();
            String message = lottoRank.getMessage();
            int count = rank.getValue();
            totalPrize += lottoRank.getPrize() * count;

            System.out.println(message + " - " + count + "개");
        }

        return totalPrize;
    }

    public static void printGrossProfitRate(int totalPrize, int ticketCount) {
        int amount = ticketCount * LOTTO_AMOUNT;
        System.out.println(GROSS_PROFIT_RATE_MESSAGE.formatMessage(((double) totalPrize / (double) amount) * 100));
    }
}
