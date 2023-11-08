package lotto;

import java.util.List;

public class LottoResultManager {
    int[] numberCount = new int[5];
    public int[] calculateCount(List<Integer> winningNumbers, Lotto[] lotto, int i, int bonusNumber) {
        int count = lotto[i].compareNumbers(winningNumbers,bonusNumber); // 로또티켓 한장과 당첨번호를 비교한 후 같은 개수
        // 숫자가 3개 일치하는 로또 개수 -> numberCount[0]
        // 숫자가 4개 일치하는 로또 개수 -> numberCount[1]
        // 숫자가 5개 일치하는 로또 개수 -> numberCount[2]
        // 숫자가 6개 일치하는 로또 개수 -> numberCount[3]
        if (count == 3){
            numberCount[0]++;
        } if (count == 4){
            numberCount[1]++;
        } if (count == 5){
            numberCount[2]++;
            if(lotto[i].equalBonus(bonusNumber)){
                numberCount[4]++;
            }
            lotto[i].equalBonus(bonusNumber);
        } if (count == 6){
            numberCount[3]++;
        }
        return numberCount;
    }

}
