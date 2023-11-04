package domain;

public class Player {
    private final LottoTickets lottoTickets;

    public Player() {
        lottoTickets = new LottoTickets();
    }

    Player(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void buyLottoTickets(int money) {
        int ticketCount = calculateTicketCount(money);
        lottoTickets.add(ticketCount);
    }

    private int calculateTicketCount(int money) {
        validateMoney(money);
        return money / LottoTickets.TICKET_COST;
    }

    private void validateMoney(int money) {
        if (money < LottoTickets.TICKET_COST) {
            throw new IllegalArgumentException();
        }
        if (money % LottoTickets.TICKET_COST != 0) {
            throw new IllegalArgumentException();
        }
    }

    int getTicketCount() {
        return lottoTickets.size();
    }
}
