package lotto.util.NumberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator implements INumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
