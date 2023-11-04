package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottoTicketsDTO;

import java.util.List;

import static lotto.constants.OutputConstants.*;

public class OutputView {

    private OutputView() {}

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PAYMENT.getValue());
    }

    public static void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        int ticketAmount = lottoTicketsDTO.getTicketAmount();
        List<Lotto> lottoTickets = lottoTicketsDTO.getLottoTickets();
        System.out.println(String.format(BOUGHT_N.getValue(), ticketAmount));
        lottoTickets.stream()
                .forEach((lottoTicket) -> System.out.println(lottoTicket.getNumbers()));
    }

    public static void printLineBreak() {
        System.out.println("");
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER.getValue());
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getValue());
    }
}
