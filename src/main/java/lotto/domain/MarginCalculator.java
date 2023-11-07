package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;

public class MarginCalculator {

    private static final String MARGIN_FORMAT = "#,###.#%";
    private final double margin;

    public MarginCalculator(Map<Rankings,Integer> result, int purchaseAmount) {
        this.margin = calculateMargin(result, purchaseAmount);
    }

    public double calculateMargin(Map<Rankings,Integer> result, int purchaseAmount) {
        return getTotalPrizeMoney(result) / purchaseAmount;
    }

    public double getTotalPrizeMoney(Map<Rankings,Integer> result) {
        int sum = 0;
        for (Rankings rankings : result.keySet()) {
            sum += rankings.getPrizeMoney(result.get(rankings));
        }
        return sum;
    }

    public String getMargin() {
        DecimalFormat df = new DecimalFormat(MARGIN_FORMAT);
        return df.format(margin);
    }
}
