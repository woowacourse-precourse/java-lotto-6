package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoTicket;

public class LottoTicketRepository {
    private static final LottoTicketRepository instance = new LottoTicketRepository();
    private final List<LottoTicket> lottoNumbers = new ArrayList<>();

    private LottoTicketRepository() {
    }

    public static LottoTicketRepository getInstance() {
        return instance;
    }

    public void addLottoNumbers(LottoTicket lottoTicket) {
        lottoNumbers.add(lottoTicket);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoNumbers;
    }
}