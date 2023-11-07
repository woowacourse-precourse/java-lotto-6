package lotto.io;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public class Output {
    private static final String OUTPUT_TICKET_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printTicket(Ticket ticket) {
        List<Lotto> lottos = ticket.getLottos();
        System.out.println(ticket.getLottos().size() + OUTPUT_TICKET_AMOUNT_MESSAGE);
        lottos.forEach(Lotto::printLotto);
    }
}
