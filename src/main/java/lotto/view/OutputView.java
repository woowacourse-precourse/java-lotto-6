package lotto.view;

import lotto.model.GameResult;
import lotto.model.Lotto;
import lotto.model.WinnerPrize;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String NOTICE_PURCHASE_LOTTO = "%d개를 구매했습니다.\n";
    private static final String NOTICE_WINNING_DETAILS = "당첨 통계\n---";
    private static final String FORMAT_OF_WINNING_DETAILS = "%s - %d개\n";

    public void printPurchaseLotto(List<Lotto> purchaseLotto) {
        int purchaseCount = purchaseLotto.size();

        System.out.printf(NOTICE_PURCHASE_LOTTO, purchaseCount);

        for (Lotto lotto : purchaseLotto) {
            System.out.println(lotto.getNumbersToString());
        }
        System.out.println();
    }

    public void printErrorMessage(Exception error) {
        System.out.println(error.getMessage());
    }

    public void printBlank() {
        System.out.println();
    }

    public void printWinningDetails() {
        System.out.println(NOTICE_WINNING_DETAILS);
        Map<WinnerPrize, Integer> gameResult = GameResult.getGameResult();
        gameResult.forEach(
                (winnerPrize, count) -> {
                    String description = winnerPrize.getDescription();
                    System.out.printf(FORMAT_OF_WINNING_DETAILS, description, count);
                }
        );
    }
}
