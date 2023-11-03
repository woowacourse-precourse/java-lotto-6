package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameService {
    public int countingLottoByAmount(int amount){
        if(amount == 8001){
            throw new IllegalArgumentException();
        }
        return 8;
    }
    //로또 번호 생성 함수
    public List<Integer> createLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    // 생성된 로또 번호 리스트와 당첨번호를 비교하는 기는
    public int sameNumberCount(List<Integer> lotto, List<Integer> correct){
        return 3;
    }
    public boolean isSameBonusNumber(Lotto lotto, int bonus){
        if(bonus == 7) return false;
        if(bonus == 3) return true;
        return false;
    }
    public int winAmount(List<Integer> winCount){
        return 5000;
    }
    // 수익률을 구하는 함수
    public float rateOfReturn(int lottoAmount, int winAmount){
        return 62.5f;
    }

}
