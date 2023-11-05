package domain;

public class Player {
    private final LottoTickets lottoTickets;
    private int money;

    public Player() {
        lottoTickets = new LottoTickets();
    }

    Player(LottoTickets lottoTickets, int money) {
        this.lottoTickets = lottoTickets;
        this.money = money;
    }

    public void buyLottoTickets(int money) {
        int ticketCount = calculateTicketCount(money);
        lottoTickets.add(ticketCount);
        this.money = money;
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

    public GameResult getRank(WinningLotto winningLotto) {
        return new GameResult(money, lottoTickets.getRanks(winningLotto));
    }
}
