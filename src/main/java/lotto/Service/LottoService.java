package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enum.Prize;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

import static lotto.Lotto.*;


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
    public int sameNumberCount(Lotto lotto, Lotto correct){
        int count =0;
        for(int number : correct.getNumbers()){
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


    public int prizeAmount(Map<Prize, Integer> winResult){
        int winAmount = 0;
        for(Prize prize : winResult.keySet()){
            winAmount += (prize.getMoney() * winResult.get(prize));
        }
        return winAmount;
    }





}
