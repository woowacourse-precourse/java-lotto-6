package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.RevenueCalculator;
import lotto.model.WinningStatistics;
import lotto.view.OutputView;

public class Lottos {
    private final List<Lotto> lottos;
    OutputView outputView = new OutputView();
    RevenueCalculator revenueCalculator = new RevenueCalculator();

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
        return IntStream.range(0, matchingCounts.size())
                .mapToObj(i -> WinningStatistics.getStatistic(matchingCounts.get(i), containBonusNumber.get(i)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void getLottoList() {
        lottos.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(outputView::printLotto);
    }

    public void getLottoListSize() {
        outputView.printLottoCount(lottos.size());
    }

    public void getLotto() {
        getLottoListSize();
        getLottoList();
    }

    public void announceWinning(List<Integer> winningNumber, int bonusNumber, int buyPrice) {
        Map<WinningStatistics, Long> winningStatistics = getWinningStatistics(winningNumber, bonusNumber);
        outputView.printWinningStatisticMessage();
        outputView.printWinningStatistic(winningStatistics);
        outputView.printEarningRate(revenueCalculator.calculateEarningRate(winningStatistics, buyPrice));
    }
}