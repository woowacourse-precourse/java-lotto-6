package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.vo.BonusNumber;

public class Statistic {

    private final Map<LottoRank, Integer> rank;

    private Statistic(Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static Statistic from(final Lotteries lotteries, final Lotto winninglotto,
                                 final BonusNumber bonusNumber) {
        return new Statistic(getResult(lotteries, winninglotto, bonusNumber));
    }

    private static Map<LottoRank, Integer> getResult(final Lotteries lotteries, final Lotto winningLotto,
                                                     final BonusNumber bonusNumber) {
        Map<LottoRank, Integer> playerRank = new HashMap<>();

        List<Lotto> playerLotteries = lotteries.getLotteries();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        playerLotteries.forEach(playerLotto ->
                calculateEachLotto(playerRank, winningNumbers, playerLotto, bonusNumber));

        return playerRank;
    }

    private static void calculateEachLotto(final Map<LottoRank, Integer> playerRank,
                                           final List<Integer> winningNumbers,
                                           final Lotto playerLottery, final BonusNumber bonusNumber) {
        List<Integer> playerNumbers = playerLottery.getNumbers();
        LottoRank rank = determineRank(countMatchedNumber(winningNumbers, playerNumbers),
                containBonusNumber(bonusNumber, playerNumbers));

        playerRank.put(rank, playerRank.getOrDefault(rank, 0) + 1);
    }

    private static LottoRank determineRank(final Integer matchedCount, final boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount().equals(matchedCount) && rank.isIncludeBonus() == hasBonus)
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    private static int countMatchedNumber(final List<Integer> winningNumbers, final List<Integer> playerNumbers) {
        return (int) playerNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean containBonusNumber(final BonusNumber bonusNumber, final List<Integer> playerNumbers) {
        Integer number = bonusNumber.number();

        if (playerNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    public Map<LottoRank, Integer> getRank() {
        return rank;
    }
}
