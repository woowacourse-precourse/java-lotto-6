package lotto.ui;

import java.util.Comparator;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;

public class LottoTicketDisplay {

    public LottoTicketDisplay() {
    }

    public void showAllLottoTicket(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            sortLottoTicketNumber(lottoTicket);
            System.out.println(lottoTicket.lottoNumber);
        }
    }

    private LottoTicket sortLottoTicketNumber(LottoTicket lottoTicket) {
        lottoTicket.lottoNumber.sort(Comparator.naturalOrder());

        return lottoTicket;
    }

    public void showTicketCount(LottoTicketGenerator lottoTicketGenerator) {
        System.out.println(lottoTicketGenerator.ticketCount + "개를 구매했습니다.");
    }

}
