package domain;

import java.util.List;

public class Player {
    private final LottoTickets lottoTickets;
    private Money money;

    public Player() {
        lottoTickets = new LottoTickets();
    }

    Player(LottoTickets lottoTickets, Money money) {
        this.lottoTickets = lottoTickets;
        this.money = money;
    }

    public void buyLottoTickets(int moneyAmount) {
        money = new Money(moneyAmount);
        lottoTickets.add(money.getTicketCount());
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public GameResult getResult(WinningLotto winningLotto) {
        return new GameResult(money, lottoTickets.getRanks(winningLotto));
    }

    public List<Lotto> getTickets() {
        return lottoTickets.getTickets();
    }
}
