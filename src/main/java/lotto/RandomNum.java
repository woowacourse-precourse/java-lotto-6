package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class RandomNum {
    public List<Integer> getRandomNum(){
        List<Integer> lottoNum = new ArrayList<>();
        while(lottoNum.size() < 6) {
            int randomNum = Randoms.pickNumberInRange(1, 45);
            if (!lottoNum.contains(randomNum)) {
                lottoNum.add(randomNum);
            }
        }
        return lottoNum;
    }
}
