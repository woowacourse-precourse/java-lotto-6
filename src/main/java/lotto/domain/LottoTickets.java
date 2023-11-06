package lotto.domain;

import java.util.List;
import lotto.view.Messages;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getSizeOfLottoTickets() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoTicket lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket.toString());
            stringBuilder.append(Messages.NEW_LINE);
        }

        return stringBuilder.toString();
    }
}
