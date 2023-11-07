package lotto.util;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;

/**
 * @author 민경수
 * @description lotto prize calculator
 * @since 2023.11.06
 **********************************************************************************************************************/
public class LottoPrizeCalculator {

    public LottoPrizeCalculator() {
    }

    public static Map<LottoPrize, Integer> getResult(WinningLotto winningLotto, LottoTickets boughtLottos) {
        List<LottoPrize> lottoPrizes = boughtLottos.getLottoPrizes(winningLotto);

        return getCountOfWinningRanks(lottoPrizes);

    }

    private static Map<LottoPrize, Integer> getCountOfWinningRanks(List<LottoPrize> winningRanks) {
        Map<LottoPrize, Integer> countOfWinningRanks = new EnumMap<>(LottoPrize.class);
        for (LottoPrize winningRank : winningRanks) {
            countOfWinningRanks.put(winningRank, countOfWinningRanks.getOrDefault(winningRank, 0) + 1);
        }

        return countOfWinningRanks;
    }


}