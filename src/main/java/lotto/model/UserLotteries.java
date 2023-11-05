package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.constants.LottoPrize;

public class UserLotteries {

    private final List<Lotto> lotteries;

    public UserLotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public int lotteriesCount() {
        return lotteries.size();
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public Map<LottoPrize, Long> findWinningCount(WinningLotto winningLotto) {
        List<LottoPrize> lottoPrizes = filterDrawnLotto(winningLotto);
        Map<LottoPrize, Long> countLottoPrize = findCountLottoPrize(lottoPrizes);
        putAllLottoPrizeCount(countLottoPrize);
        return countLottoPrize;
    }

    private Map<LottoPrize, Long> findCountLottoPrize(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<LottoPrize> filterDrawnLotto(WinningLotto winningLotto) {
        return lotteries.stream()
                .filter(winningLotto::isDrawnLotto)
                .map(winningLotto::findLottoPrizeType)
                .toList();
    }

    private void putAllLottoPrizeCount(Map<LottoPrize, Long> winningCount) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            putIfNotHaveLottoPrizeKey(winningCount, lottoPrize);
        }
    }

    private void putIfNotHaveLottoPrizeKey(Map<LottoPrize, Long> winningCount, LottoPrize lottoPrize) {
        if (!winningCount.containsKey(lottoPrize)) {
            winningCount.put(lottoPrize, 0L);
        }
    }

}
