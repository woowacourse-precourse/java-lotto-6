package lotto.ui;

import static lotto.constants.ErrorMessage.ERROR_MESSAGE_FORMAT;
import static lotto.constants.ResultMessage.PURCHASE_MESSAGE_FORMAT;
import static lotto.constants.ResultMessage.RESULT_BONUS_OUTPUT_FORMAT;
import static lotto.constants.ResultMessage.RESULT_OUTPUT_FORMAT;
import static lotto.constants.ResultMessage.RESULT_VIEW_FORMAT;
import static lotto.constants.ResultMessage.REVENUE_FORMAT;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Lotto;

public class ResultView {

    public void printPurchasedTickets(List<Lotto> purchasedTickets) {
        System.out.printf(PURCHASE_MESSAGE_FORMAT, purchasedTickets.size());
        for (Lotto ticket : purchasedTickets) {
            ticket.printNumbers();
        }
    }

    private void printSingleResult(GameResult result) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        if (result.getIsBonus()) {
            System.out.printf(RESULT_BONUS_OUTPUT_FORMAT, result.getMatchCount(),
                    decFormat.format(result.getPrizeMoney()), result.getResultCount());
            return;
        }
        System.out.printf(RESULT_OUTPUT_FORMAT, result.getMatchCount(),
                decFormat.format(result.getPrizeMoney()), result.getResultCount());
    }

    public void printResult(GameResult[] values, double revenue) {
        System.out.printf(RESULT_VIEW_FORMAT);
        for (GameResult result : values) {
            printSingleResult(result);
        }
        System.out.printf(REVENUE_FORMAT, revenue);
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
