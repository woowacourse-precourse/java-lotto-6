package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {
    private static NumberGenerator numberGenerator;
    private NumberGenerator() {

    }
    public static NumberGenerator getInstance() {
        if (numberGenerator == null) {
            numberGenerator = new NumberGenerator();
        }
        return numberGenerator;
    }
    public Integer createRandomGenerator(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

    public List<Integer> createRandom6Numbers(int start, int end, int num) {
        return Randoms.pickUniqueNumbersInRange(start, end, num);
    }
}
