package lotto.LottoController;

import lotto.Lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalculatorResult {

    public Map<Lotto.LottoRank, Integer> calculateResults(List<Lotto> lottos, Lotto winNumbers, int bonusNumber) {
        Map<Lotto.LottoRank, Integer> result = new HashMap<>();

        for (Lotto.LottoRank rank : Lotto.LottoRank.values()) {
            result.put(rank, 0);
        }

        for (Lotto currntLotto : lottos) {
            Lotto.LottoRank rank = currntLotto.determineRank(winNumbers, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public String calculateProfit(Map<Lotto.LottoRank, Integer> result, int purchaseAmount) {
        int totalPrize = 0;

        for (Map.Entry<Lotto.LottoRank, Integer> entry : result.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }

        double profitRate = (double) totalPrize / purchaseAmount * 100;

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());

        return numberFormat.format(profitRate) + "%";
    }
}
