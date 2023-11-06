package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoMatch {
    private static boolean hasBonus;
    public static List<Integer> countMatchingNumbers(List<List<Integer>> totalLottoNumbers, List<Integer> winningNumbers, int bonus) {
        List<Integer> countWinnings = new ArrayList<>();
        int[] prizeCounts = new int[LottoPrize.values().length];
        for (List<Integer> lottoNumbers : totalLottoNumbers) {
            int count = countMatchingNumbersInSingleLotto(lottoNumbers, winningNumbers, bonus);
            LottoPrize prize = LottoPrize.checkLottoResult(count, hasBonus);
            prizeCounts[prize.ordinal()]++;
        }
        for (int i = 0; i < prizeCounts.length; i++) {
            countWinnings.add(prizeCounts[i]);
        }
        return countWinnings;
    }
    public static boolean isContainBonus(List<Integer>lottoNumbers,int bonus){
        return lottoNumbers.contains(bonus);
    }
    public static boolean getHasBonus(){
        return hasBonus;
    }
    private static int countMatchingNumbersInSingleLotto(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonus) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        if (count == 5 && isContainBonus(lottoNumbers,bonus) ){
            hasBonus = true;
        }
        return count;
    }
}
