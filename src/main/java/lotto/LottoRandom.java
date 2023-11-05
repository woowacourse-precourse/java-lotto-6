package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class LottoRandom {
    public LottoRandom() {

    }
    private List<Integer> lottoNumber;
    public List<Integer> randomNum() {
        List<Integer> lottoNum = new ArrayList<>();
        while (lottoNum.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNum.contains(randomNumber)) {
                lottoNum.add(randomNumber);
            }
        }
        lottoNum.sort(Comparator.naturalOrder());
        return lottoNum;
    }
}
