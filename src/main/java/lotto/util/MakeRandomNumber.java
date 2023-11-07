package lotto.util;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
// 여기서 랜덤 넘버로 리스트 뽑아주고 로또에서 사용자 수 만큼 뽑아주는 기능 짜기
public class MakeRandomNumber implements RandomNum {
    @Override
    public List<Integer> getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
