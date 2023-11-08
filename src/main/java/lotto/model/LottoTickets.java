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

    public long getTotalPrize(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> numbers = winningNumbers.getWinningNumbers();
        int bonus = bonusNumber.getBonusNumber();
        return lottoTickets.stream()
                .mapToLong(lotto -> lotto.getPrize(numbers, bonus))
                .sum();
    }

    public Map<Integer, Long> getEachPrize(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> numbers = winningNumbers.getWinningNumbers();
        int bonus = bonusNumber.getBonusNumber();
        return lottoTickets.stream()
                .map(lotto -> lotto.getPrize(numbers, bonus))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
