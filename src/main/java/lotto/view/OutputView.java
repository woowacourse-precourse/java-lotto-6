package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.utils.GameMessage;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.printf(GameMessage.PURCHASED_TICKET_COUNT.getMessage(), ticketCount);
        System.out.println();
    }

    public static void printUserLottos(List<Lotto> userLottos) {
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
