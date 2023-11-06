package lotto;

import lotto.Lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LottoResultCalculator {

    private static final Map<Integer, Integer> prizeMap = new HashMap<>();
    private static final int BOUNUS_MATCH = 7;

    static {
        prizeMap.put(3, 5_000);
        prizeMap.put(4, 50_000);
        prizeMap.put(5, 1_500_000);
        prizeMap.put(BOUNUS_MATCH, 30_000_000);
        prizeMap.put(6, 2_000_000_000);
    }

    public Map<Integer, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> results = new HashMap<>();
        lottos.forEach(lotto -> {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                matchCount++; // Increment to signify bonus number match
            }
            results.put(matchCount, results.getOrDefault(matchCount, 0) + 1);
        });
        return results;
    }

    public static String getPrizeAmount(int matchCount) {
        Integer prizeAmount = prizeMap.getOrDefault(matchCount, 0);
        return formatNumber(prizeAmount);
    }

    private static String formatNumber(int number){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return numberFormat.format(number);
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}