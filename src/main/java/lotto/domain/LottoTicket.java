package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        validate(tickets);
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int getLottoCount() {
        return tickets.size();
    }

    private void validate(List<Lotto> lottoTicket) {
        if (lottoTicket == null || lottoTicket.isEmpty()) {
            throw new IllegalArgumentException("로또를 생성할 수 없습니다.");
        }
    }

}
