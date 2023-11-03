package domain;

public class Player {
    private final LottoTickets lottoTickets = new LottoTickets();
    public void buyLottoTickets(int count) {
        lottoTickets.add(count);
    }

    int getTicketCount() {
        return lottoTickets.size();
    }
}
