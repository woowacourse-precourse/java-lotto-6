package lotto.ui;

import java.util.ArrayList;
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
        List<Integer> sortedNumbers = new ArrayList<>(lottoTicket.lottoNumber);
        sortedNumbers.sort(Comparator.naturalOrder());
        return new LottoTicket(sortedNumbers);
    }

    public void showTicketCount(LottoTicketGenerator lottoTicketGenerator) {
        System.out.println(lottoTicketGenerator.ticketCount + "개를 구매했습니다.");
    }

}
