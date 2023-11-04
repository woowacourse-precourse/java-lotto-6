package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.Lotto.*;
import static lotto.LottoController.bonus;
import static lotto.LottoController.winResult;

public class LottoService {
    static final String THREE_CORRECT = "3개 일치 (5,000원)";
    static final String FOUR_CORRECT = "4개 일치 (50,000원)";
    static final String FIVE_CORRECT_NOT_BONUS = "5개 일치 (1,500,000원)";
    static final String FIVE_CORRECT_MATCH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    static final String SIX_CORRECT = "6개 일치 (2,000,000,000원)";


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
            winResult.put(THREE_CORRECT, winResult.get(THREE_CORRECT) + 1);
            winAmount += 5000;
        }
        if (count == 4) {
            winResult.put(FOUR_CORRECT, winResult.get(FOUR_CORRECT) + 1);
            winAmount += 50000;
        }
        if (count == 5) {
            if (isSameBonusNumber(lotto, bonus)) {
                winResult.put(FIVE_CORRECT_MATCH_BONUS, winResult.get(FIVE_CORRECT_MATCH_BONUS) + 1);
                winAmount += 30000000;
            }
            if (!isSameBonusNumber(lotto, bonus)) {
                winResult.put(FIVE_CORRECT_NOT_BONUS, winResult.get(FIVE_CORRECT_NOT_BONUS) + 1);
                winAmount += 1500000;
            }
        }
        if (count == 6) {
            winResult.put(SIX_CORRECT, winResult.get(SIX_CORRECT) + 1);
            winAmount += 2000000000;
        }
        return winAmount;
    }


}
