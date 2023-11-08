package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
/**
 * @author 김지환
 * 
 * 로또 기능을 담당하는 클래스
 */
public class LottoManager {
    
    /*로또번호를 담는 2차원 리스트*/
    public List<List<Integer>> generateLottoTickets(int numberOfPurchasedLotto) {
        List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchasedLotto; i++) {
            List<Integer> lottoNumbers = drawLottoNumbers();
            purchasedLottoNumbers.add(lottoNumbers);
        }
        return purchasedLottoNumbers;
    }
    
    /*로또번호를 추첨하는 메서드*/
    public List<Integer> drawLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(randomNumbers);
        return randomNumbers;
    }
    
    /*3개~6개의 번호가 맞을경우 enum을 통해 관리*/
    public int[] recordMatches(List<List<Integer>> purchasedLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCount = new int[MatchType.values().length];
        for (List<Integer> numbers : purchasedLottoNumbers) {
            int matchingNumbers = countMatchingNumbers(numbers, winningNumbers, bonusNumber);
            updateMatchArr(matchCount, matchingNumbers);
        }
        return matchCount;
    }
    
    /*5개가 맞고 보너스번호도 맞는지 확인하는 메서드*/
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
    
    
    /*5개가 맞고 보너스도 맞을경우 및 다른 경우의 수의 enum을 관리하는 메서드*/
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
