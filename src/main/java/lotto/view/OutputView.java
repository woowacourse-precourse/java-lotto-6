package lotto.view;

import lotto.constants.OutputConstants;
import lotto.domain.Lotto;
import lotto.dto.LottoTicketsDTO;

import java.util.List;

public class OutputView {

    private OutputView() {}

    public static void printInputPurchaseAmount() {
        System.out.println(OutputConstants.INPUT_PAYMENT.getValue());
    }

    public static void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        int ticketAmount = lottoTicketsDTO.getTicketAmount();
        List<Lotto> lottoTickets = lottoTicketsDTO.getLottoTickets();
        System.out.println(String.format(OutputConstants.BOUGHT_N.getValue(), ticketAmount));
        lottoTickets.stream()
                .forEach((lottoTicket) -> System.out.println(lottoTicket.getNumbers()));
    }

    public static void printLineBreak() {
        System.out.println("");
    }
}
