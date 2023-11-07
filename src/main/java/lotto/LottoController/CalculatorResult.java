package lotto.LottoController;

import lotto.LottoModel.Lotto;
import lotto.LottoModel.LottoRank;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalculatorResult {

    public Map<LottoRank, Integer> calculateResults(List<Lotto> lottos, Lotto winNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = initializeResult();

        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.determineRank(winNumbers, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private Map<LottoRank, Integer> initializeResult() {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    public String calculateProfit(Map<LottoRank, Integer> result, int purchaseAmount) {
        int totalPrize = TotalPrize(result);
        double profitRate = (double) totalPrize / purchaseAmount * 100;

        return formatProfit(profitRate);
    }

    private int TotalPrize(Map<LottoRank, Integer> result) {
        int totalPrize = 0;

        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    private String formatProfit(double profitRate) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());

        return numberFormat.format(profitRate) + "%";
    }
}
