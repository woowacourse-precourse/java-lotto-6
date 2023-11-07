package lotto;

import java.util.List;

public class SoldLotto {
    private final List<Lotto> lottoTickets;

    public SoldLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static double getReturnRate(Amount purchaseAmount, List<LottoRanking> lottoRankings) {
        Amount totalPrizeMoney = LottoRanking.getTotalPrizeMoney(lottoRankings);
        return Amount.calculateReturnRate(purchaseAmount, totalPrizeMoney);
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .reduce((lottoMessage, lotto) -> lottoMessage + System.lineSeparator() + lotto)
                .orElse(System.lineSeparator());
    }

    public int getSoldLottoTicketsCount() {
        return lottoTickets.size();
    }

    public List<LottoRanking> checkLottoResults(WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(winningLotto::checkLottoResult)
                .toList();
    }
}
