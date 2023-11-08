package lotto.utils;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.UserLotteries;
import lotto.model.WinningLotto;

public class UsersPrizeLottoCounter {

    public static Map<LottoPrize, Long> countPrizeLotto(WinningLotto winningLotto, UserLotteries userLotteries) {
        List<Lotto> drawnUserLotto = filterDrawnUserLotto(winningLotto, userLotteries);
        Map<LottoPrize, Long> lottoPrizeCount = groupByLottoPrize(winningLotto, drawnUserLotto);
        allocateZeroToNull(lottoPrizeCount);
        return lottoPrizeCount;
    }

    private static List<Lotto> filterDrawnUserLotto(WinningLotto winningLotto, UserLotteries userLotteries) {
        return userLotteries.getLotteries()
                .stream()
                .filter(winningLotto::isDrawnLotto)
                .toList();
    }

    private static Map<LottoPrize, Long> groupByLottoPrize(WinningLotto winningLotto, List<Lotto> drawnLotteries) {
        return drawnLotteries
                .stream()
                .map(winningLotto::findLottoPrizeType)
                .collect(groupingBy(Function.identity(), () -> new EnumMap<>(LottoPrize.class), counting()));
    }

    private static void allocateZeroToNull(Map<LottoPrize, Long> userLotteries) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            userLotteries.putIfAbsent(lottoPrize, 0L);
        }
    }

}
