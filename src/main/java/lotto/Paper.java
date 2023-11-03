package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Collections;

public class Paper {
    private List<Integer> numbers;
    private int correspondNumber;
    public void pickLottoNumber(){
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
    }

    public List<Integer> getNumber(){
        return numbers;
    }

    public void checkCorrespondNum(List<Integer> winNumbers, int bonusNumber){
        int cnt=0;
        for(int i : winNumbers){
            if(numbers.contains(i)){
                cnt++;
            }
        }
        if(cnt==5 && numbers.contains(bonusNumber)){
            correspondNumber = 7;
            return;
        }
        correspondNumber=cnt;
    }

    public int getCorrespondNum(){
        return correspondNumber;
    }

}
