package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final HashMap<Rank, Integer> result = new HashMap<>();

    public void calculateWinningResult(Lottos lottos, String inputWinningNumber, int bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = checkRank(lotto, inputWinningNumber, bonusNumber);
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

    private Rank checkRank(Lotto lotto, String inputWinningNumber, int bonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
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
