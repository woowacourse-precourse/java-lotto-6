package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberRandomGenerator {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int NUMBER = 6;

    public List<Integer> generate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, NUMBER);
        return numbers;
    }

}
