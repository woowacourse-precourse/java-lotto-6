package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class LottoTicketGenerator {
    public static LottoTicket generateLottoTickets(int lottoTicketCount) {
        LottoTicket ticket = new LottoTicket();
        List<Lotto> lottoRandomNumbers = LottoTicket.randomLottoNumbers(lottoTicketCount);

        for (Lotto lotto : lottoRandomNumbers) {
            ticket.addLotto(lotto);
        }
        return ticket;
    }
    public static void printLottoTickets(LottoTicket ticket) {
        ticket.getLottoGames().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
