package lotto.util;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class MakeRandomNumber implements RandomNum {
    @Override
    public List<Integer> getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
