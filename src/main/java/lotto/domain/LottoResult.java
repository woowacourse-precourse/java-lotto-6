package lotto.domain;

import lotto.view.InputView;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final HashMap<Rank, Integer> result = new HashMap<>();

    public HashMap<Rank, Integer> getResult() {
        return result;
    }

    public void calculateWinningResult(Lottos lottos, List<Integer> inputWinningNumber, int bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = checkRank(lotto, inputWinningNumber, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public String calculateProfitRate(int inputPrice) {
        double totalPrize = 0;
        double userPrice = (double) inputPrice;

        for (Rank rank : result.keySet()) {
            totalPrize += rank.getWinningAmount() * result.get(rank);
        }

        double profitRate = (totalPrize / userPrice) * 100;

        profitRate = Math.round(profitRate * 100) / 100.0;

        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(1);
        return formatter.format(profitRate);
    }

    private Rank checkRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return findRank(matchCount, matchBonus);
    }

    private Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount && matchCondition(rank, matchCount, matchBonus))
                .findFirst()
                .orElse(Rank.MATCH_0);
    }

    private boolean matchCondition(Rank rank, int matchCount, boolean matchBonus) {
        if (rank.getMatchCount() != matchCount) {
            return false;
        }

        if (matchCount == 5) {
            return rank.isMatchBonous() == matchBonus;
        }

        return true;
    }


}
