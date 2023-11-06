package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Util {
    public List<Integer> createRandomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
