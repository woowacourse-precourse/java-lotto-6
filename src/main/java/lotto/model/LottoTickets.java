package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public long getTotalPrize(List<Integer> winningNumbers, int bonusNumber) {
        return lottoTickets.stream()
                .mapToLong(lotto -> lotto.getPrize(winningNumbers, bonusNumber))
                .sum();
    }

    public Map<Integer, Long> getEachPrize(List<Integer> winningNumbers, int bonusNumber) {
        return lottoTickets.stream()
                .map(lotto -> lotto.getPrize(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double calculateReturnRate(int buyMoney, long totalPrize) {
        return ((double) totalPrize / buyMoney) * 100;
    }

    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
