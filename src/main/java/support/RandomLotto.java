package support;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLotto {

    public List<Integer> getRandomLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }


}
