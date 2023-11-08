package lotto.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public static String getProfitRate(Map<LottoPrize, Integer> countOfWinningRanks, LottoTickets boughtLottos) {
        BigDecimal result = BigDecimal.valueOf(0);

        for (LottoPrize lottoPrize : countOfWinningRanks.keySet()) {
            result = result.add(BigDecimal.valueOf(lottoPrize.amount() * countOfWinningRanks.get(lottoPrize)));
        }

        BigDecimal rate = result.divide(boughtLottos.totalPurchasedAmount(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

        return String.format("%.1f", rate);
    }

    private static Map<LottoPrize, Integer> getCountOfWinningRanks(List<LottoPrize> winningRanks) {
        Map<LottoPrize, Integer> countOfWinningRanks = new EnumMap<>(LottoPrize.class);
        for (LottoPrize winningRank : winningRanks) {
            countOfWinningRanks.put(winningRank, countOfWinningRanks.getOrDefault(winningRank, 0) + 1);
        }

        return countOfWinningRanks;
    }

}