package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoMatch {
    private static boolean hasBonus;
    public static List<Integer> countMatchingNumbers(List<List<Integer>> totalNumbers,List<Integer> winningNumbers, int bonus) {
        List<Integer> countWinnings = new ArrayList<>();
        int count = 0;
        for (List<Integer> numbers : totalNumbers) {
            count += countMatchingNumbersInSingleLotto(numbers, winningNumbers, bonus);
            countWinnings.add(count);
            count=0;
        }
        //System.out.println("일치 개수 리스트 = "+countWinnings);
        return countWinnings;
    }
    public static boolean isHasbonus(List<Integer>lottoNumbers,int bonus){
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
        if (count == 5 && isHasbonus(lottoNumbers,bonus) ){
            hasBonus = true;
        }
        //System.out.println("일치 개수 : " + count);
        return count;
    }


}
