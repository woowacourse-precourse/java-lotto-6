package lotto.domain;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchasedLottoTickets {

    private final List<Lotto> lottoTickets;

    public PurchasedLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public int size() {
        return lottoTickets.size();
    }

    public PurchasedLottoStatistics collectStatistics(Lotto winningLotto, int bonusNumber) {
        Map<LottoWinning, Long> statistics = lottoTickets.stream()
                .map(lotto -> lotto.confirmLottoWinning(winningLotto, bonusNumber))
                .collect(groupingBy(lottoWinning -> lottoWinning, Collectors.counting()));
        return new PurchasedLottoStatistics(statistics);
    }
}
