package lotto.ui;

import java.util.Comparator;
import java.util.List;
import lotto.domain.LottoTicket;

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

}
