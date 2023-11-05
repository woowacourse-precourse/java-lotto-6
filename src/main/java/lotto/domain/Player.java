package lotto.domain;

import java.util.List;

public class Player {

    private List<Lotto> lottoTickets;

    public Player(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoRank> checkLottoTickets(WinningNumber winningNumber){
        return lottoTickets.stream()
                .map(winningNumber::getLottoRank)
                .toList();
    }

}
