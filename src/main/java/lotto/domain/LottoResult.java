package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final HashMap<Rank, Integer> result = new HashMap<>();

    public void calculateWinningResult(Lottos lottos, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = checkRank(lotto, winningNumber, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public String calculateProfitRate(String inputPrice) {
        double totalPrize = 0;
        double userPrice = Double.parseDouble(inputPrice);

        for (Rank rank : result.keySet()) {
            totalPrize += rank.getWinningAmount() * result.get(rank);
        }

        double profitRate = (totalPrize / userPrice) * 100;

        profitRate = Math.round(profitRate * 100) / 100.0;

        return String.format("%.1f", profitRate);
    }

    private Rank checkRank(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumber::contains)
                .count();

        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return findRank(matchCount, matchBonus);
    }

    private Rank findRank(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && rank.isMatchBonous() == matchBonus) {
                return rank;
            }
        }

        return Rank.MATCH_0;
    }

}
