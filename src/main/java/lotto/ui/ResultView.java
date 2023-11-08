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

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
