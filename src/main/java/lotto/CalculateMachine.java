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

    private static List<Integer> compareResult(){
        List<Integer> compareResult = new ArrayList<>();
        for (List<Integer> integers : allLottoCollection) {
            int matchCnt = countMatchingNumbers(integers, winningNumbers);
            if(matchCnt >= 3) {
                compareResult.add(matchCnt);
            }
        }
        return compareResult;
    }

    private static int countMatchingNumbers(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean matchingBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    public int[] calculateResult(){
        int[] lottoResult = new int[7];
        List<Integer> lottoCompareResult = compareResult();
        boolean bonusNumber = matchingBonusNumber();
        for(int oneLottoResult : lottoCompareResult){
            if(oneLottoResult == 6 || (oneLottoResult == 5 && bonusNumber)){
                lottoResult[oneLottoResult]++;
                continue;
            }
            lottoResult[oneLottoResult-1]++;
        }
        return lottoResult;
    }

}
