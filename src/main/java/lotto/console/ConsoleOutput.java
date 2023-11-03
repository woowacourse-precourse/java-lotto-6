package lotto.console;

import static lotto.constant.LottoMessage.LOTTO_TICKETS_MESSAGE;
import static lotto.constant.LottoMessage.LOTTO_TICKETS_QUANTITY_MESSAGE;

import java.util.List;
import lotto.dto.LottoTicketsDto;
import lotto.model.Lotto;

public class ConsoleOutput {
    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        int quantity = lottoTicketsDto.quantity();
        List<Lotto> lottoTickets = lottoTicketsDto.lottoTickets();

        StringBuilder purchaseInfo = new StringBuilder();

        purchaseInfo.append(String.format(LOTTO_TICKETS_QUANTITY_MESSAGE, quantity));

        for (Lotto lottoTicket : lottoTickets) {
            purchaseInfo.append(String.format(LOTTO_TICKETS_MESSAGE, lottoTicket.toString()));
        }

        System.out.println(purchaseInfo);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
