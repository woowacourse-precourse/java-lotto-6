package lotto.view;

import static lotto.view.constants.ConstantMessage.RESPONSE_FIFTH;
import static lotto.view.constants.ConstantMessage.RESPONSE_FIRST;
import static lotto.view.constants.ConstantMessage.RESPONSE_FOURTH;
import static lotto.view.constants.ConstantMessage.RESPONSE_HYPHEN_SEPARATOR;
import static lotto.view.constants.ConstantMessage.RESPONSE_PROFIT_RATE;
import static lotto.view.constants.ConstantMessage.RESPONSE_PURCHASE_AMOUNT;
import static lotto.view.constants.ConstantMessage.RESPONSE_SECOND;
import static lotto.view.constants.ConstantMessage.RESPONSE_THIRD;
import static lotto.view.constants.ConstantMessage.RESPONSE_WINNING_STATISTICS;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constants.ConstantMessage;

public class OutputView {
    public static void responsePurchaseAmount(int amount, List<Lotto> automaticTickets) {
        ConstantMessage.printConstantMessage(RESPONSE_PURCHASE_AMOUNT, amount);
        for (Lotto automaticTicket : automaticTickets) {
            System.out.println(automaticTicket.getNumbers());
        }
    }

    public static void responseWinningStatics() {
        ConstantMessage.printConstantMessage(RESPONSE_WINNING_STATISTICS);
        ConstantMessage.printConstantMessage(RESPONSE_HYPHEN_SEPARATOR);
        ConstantMessage.printConstantMessage(RESPONSE_FIFTH);
        ConstantMessage.printConstantMessage(RESPONSE_FOURTH);
        ConstantMessage.printConstantMessage(RESPONSE_THIRD);
        ConstantMessage.printConstantMessage(RESPONSE_SECOND);
        ConstantMessage.printConstantMessage(RESPONSE_FIRST);
        ConstantMessage.printConstantMessage(RESPONSE_PROFIT_RATE);
    }
}
