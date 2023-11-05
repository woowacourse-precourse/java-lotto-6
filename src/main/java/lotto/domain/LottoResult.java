package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static void checkLottoBundle(List<List<Integer>> IssuedLotto, List<Integer> numbers, int bonusNumber) {
        Map<LottoPrize, Integer> prizeCounts = initializePrizeCounts();

        for (List<Integer> oneLotto : IssuedLotto) {
            int matchedNumbers = countMatchedNumbers(oneLotto, numbers);
            boolean hasBonusNumber = oneLotto.contains(bonusNumber);
            LottoPrize prize = decidePrize(matchedNumbers, hasBonusNumber);

            updatePrizeCounts(prizeCounts, prize);
        }
        showResults(prizeCounts);
    }

    private static int countMatchedNumbers(List<Integer> oneLotto, List<Integer> numbers) {
        int count = 0;

        for (int number : oneLotto) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static LottoPrize decidePrize(int matchedNumbers, boolean hasBonusNumber) {
        LottoPrize prize = decideMatchFivePrize(matchedNumbers, hasBonusNumber);

        if (prize != null) {
            return prize;
        }
        return decideGeneralPrize(matchedNumbers);
    }

    private static LottoPrize decideMatchFivePrize(int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 5 && hasBonusNumber) {
            return LottoPrize.matchFiveBonus;
        }
        if (matchedNumbers == 5) {
            return LottoPrize.matchFive;
        }
        return null;
    }

    private static LottoPrize decideGeneralPrize(int matchedNumbers) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.getMatchedNumbers() == matchedNumbers) {
                return prize;
            }
        }
        return null;
    }

    private static Map<LottoPrize, Integer> initializePrizeCounts() {
       Map<LottoPrize, Integer> prizeCounts = new HashMap<>();
       for (LottoPrize prize : LottoPrize.values()) {
           prizeCounts.put(prize, 0);
       }
        return prizeCounts;
    }

    private static void updatePrizeCounts(Map<LottoPrize, Integer> prizeCounts, LottoPrize prize) {
        if (prize != null) {
            prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        }
    }

    private static void showResults(Map<LottoPrize, Integer> prizeCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCounts.get(prize);
            String bonusDescription = prize.getMatchedNumbers() + "개 일치";
            if (prize == LottoPrize.matchFiveBonus) {
                bonusDescription += ", 보너스 볼 일치";
            }
            System.out.println("(" + prize.getPrize() + "원) - " + count + "개");
        }
    }
}
