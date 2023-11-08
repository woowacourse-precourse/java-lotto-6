package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.Rank;

import java.util.Map;

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

    public static void printResult(Map<Rank, Integer> winningCounts) {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println("---");

        for (Map.Entry<Rank, Integer> rank : winningCounts.entrySet()) {
            Rank lottoRank = rank.getKey();
            String message = lottoRank.getMessage();
            int count = rank.getValue();

            System.out.println(message + " - " + count + "개");
        }
    }
}
