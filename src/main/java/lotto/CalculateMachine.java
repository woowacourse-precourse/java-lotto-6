package lotto;

import java.util.ArrayList;
import java.util.List;

public class CalculateMachine {
    private static List<List<Integer>> allLottoCollection;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    public CalculateMachine(List<List<Integer>> allLottoCollection, List<Integer> winningNumbers, int bonusNumber) {
        this.allLottoCollection = allLottoCollection;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private int matchingLottoNumbers(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean matchingBonusNumber(List<Integer> lotto) {
        if (lotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
    //맞은 숫자의 개수와 맞은 보너스 숫자 유무에 따라 몇번 인덱스에 들어갈지 정해줌
    private int calculateRank(int matchingLotto, boolean matchingBonus){

        if(matchingLotto == 6){
            return 5;
        }
        if(matchingLotto == 5 & matchingBonus){
            return 4;
        }

        return matchingLotto - 2;
    }

    public int[] lottoResult(){
        int[] lottoResult = new int[6];

        for (List<Integer> lottoCollection : allLottoCollection) {

            int matchingLotto = matchingLottoNumbers(lottoCollection, winningNumbers);
            boolean matchingBonus = matchingBonusNumber(lottoCollection);

            if(matchingLotto > 2) {
                lottoResult[calculateRank(matchingLotto,matchingBonus)]++;
            }
        }
        return lottoResult;
    }

    public double profitResult(int invest , int[] lottoResult){

        int[] prize = {0,5000,50000,1500000,30000000,2000000000};
        int totalPrize = 0;
        for(int i=1; i<lottoResult.length; i++){
            totalPrize += lottoResult[i] * prize[i];
        }

        double profitPercentage =Math.round(((double) totalPrize / invest) * 100 * 100) / 100.0;

        return Math.max(0,profitPercentage);
    }
}
