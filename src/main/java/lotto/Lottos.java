package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.WinningStatistics;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> checkWinning(List<Integer> winningNumber) {
        return lottos.stream()
                .map(lotto -> lotto.checkNumbers(winningNumber))
                .collect(Collectors.toList());
    }

    public List<Boolean> checkBonusNumber(int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.checkBonusNumber(bonusNumber))
                .collect(Collectors.toList());
    }

    public Map<WinningStatistics, Long> getWinningStatistics(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> matchingCounts = checkWinning(winningNumber);
        List<Boolean> containBonusNumber = checkBonusNumber(bonusNumber);
        Map<WinningStatistics, Integer> result = new HashMap<>();
        return IntStream.range(0, matchingCounts.size())
                .mapToObj(i -> WinningStatistics.getStatistic(matchingCounts.get(i), containBonusNumber.get(i)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}