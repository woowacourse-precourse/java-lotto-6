package lotto.domain;

import java.util.List;

public class Player {

    private final List<Lotto> lottoTickets;
    private final int money;

    public Player(List<Lotto> lottoTickets, int money) {
        this.lottoTickets = lottoTickets;
        this.money = money;
    }


    public List<LottoRank> checkLottoTickets(WinningNumber winningNumber) {
        return lottoTickets.stream()
                .map(winningNumber::getLottoRank)
                .toList();
    }

    public int getMoney() {
        return money;
    }
}
