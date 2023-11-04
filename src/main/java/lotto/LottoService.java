package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.Lotto.*;
import static lotto.LottoController.bonus;
import static lotto.LottoController.winResult;

public class LottoService {

    public int countingLottoByAmount(int amount){
        if(amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return amount / 1000;
    }

    //로또 번호 생성 함수
    public List<Integer> createLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }

    // 생성된 로또 번호 리스트와 당첨번호를 비교하는 기는
    public int sameNumberCount(Lotto lotto, List<Integer> correct){
        int count =0;
        for(int number : correct){
            if(lotto.getNumbers().contains(number)){
                count++;
            }
        }
        return count;
    }

    public boolean isSameBonusNumber(Lotto lotto, int bonus){
        return lotto.getNumbers().contains(bonus);
    }


    // 수익률을 구하는 함수
    public String rateOfReturn(int lottoAmount, int winAmount){
        return String.format("%.1f",((float)winAmount / (float)lottoAmount * 100f));
    }


    public int insertResult(Lotto lotto, List<Integer> winNumbers) {
        int count = sameNumberCount(lotto, winNumbers);
        int winAmount = 0;
        if (count == 3) {
            winResult.put(Prize.THREE_CORRECT, winResult.get(Prize.THREE_CORRECT) + 1);
            winAmount += Prize.THREE_CORRECT.getMoney();
        }
        if (count == 4) {
            winResult.put(Prize.FOUR_CORRECT, winResult.get(Prize.FOUR_CORRECT) + 1);
            winAmount += Prize.FOUR_CORRECT.getMoney();
        }
        if (count == 5) {
            if (isSameBonusNumber(lotto, bonus)) {
                winResult.put(Prize.FIVE_CORRECT_MATCH_BONUS, winResult.get(Prize.FIVE_CORRECT_MATCH_BONUS) + 1);
                winAmount += Prize.FIVE_CORRECT_MATCH_BONUS.getMoney();
            }
            if (!isSameBonusNumber(lotto, bonus)) {
                winResult.put(Prize.FIVE_CORRECT_NOT_BONUS, winResult.get(Prize.FIVE_CORRECT_NOT_BONUS) + 1);
                winAmount += Prize.FIVE_CORRECT_NOT_BONUS.getMoney();
            }
        }
        if (count == 6) {
            winResult.put(Prize.SIX_CORRECT, winResult.get(Prize.SIX_CORRECT) + 1);
            winAmount += Prize.SIX_CORRECT.getMoney();
        }
        return winAmount;
    }


}
