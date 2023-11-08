package lotto.adapter;

import java.util.List;
import lotto.StringConstants;
import lotto.domain.Lotto;
import lotto.port.OutputPort;

public class LottoPrinter {

    private final OutputPort outputPort;

    public LottoPrinter(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    public void printLottoTickets(List<Lotto> issuedTickets) {
        outputPort.printLine(issuedTickets.size() + StringConstants.PURCHASED_COUNT_MESSAGE);

        for (Lotto ticket : issuedTickets) {
            outputPort.printLine(ticket.getNumbers());
        }
    }
}