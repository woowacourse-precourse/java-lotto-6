package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    
    public List<List<Integer>> generateLottoTickets(int numberOfPurchasedLotto) {
        List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchasedLotto; i++) {
            List<Integer> lottoNumbers = drawLottoNumbers();
            purchasedLottoNumbers.add(lottoNumbers);
        }
        return purchasedLottoNumbers;
    }
    
    public List<Integer> drawLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(randomNumbers);
        return randomNumbers;
    }
    
    public int[] recordMatches(List<List<Integer>> purchasedLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCount = new int[MatchType.values().length];
        for (List<Integer> numbers : purchasedLottoNumbers) {
            int matchingNumbers = countMatchingNumbers(numbers, winningNumbers, bonusNumber);
            updateMatchArr(matchCount, matchingNumbers);
        }
        return matchCount;
    }
    
    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int cnt = 0;
        boolean isBonus = false;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                cnt++;
            }
            if (number == bonusNumber) {
                isBonus = true;
            }
        }
        if (cnt == 5 && isBonus) {
            return 7;
        }
        return cnt;
    }
    
    private void updateMatchArr(int[] matchArr, int matchingNumbers) {
        if (matchingNumbers == 7 ) {
            matchArr[MatchType.FIVE_WITH_BONUS.ordinal()]++;
        } else if(matchingNumbers != 7) {
            for (MatchType matchType : MatchType.values()) {
                if (matchingNumbers == matchType.getMatchingNumbers()) {
                    matchArr[matchType.ordinal()]++;
                    break;
                }
            }
        }
    }
    
}
