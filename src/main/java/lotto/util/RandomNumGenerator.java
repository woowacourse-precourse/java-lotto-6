package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumGenerator {

    private int startNum;
    private int endNum;

    public RandomNumGenerator(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public List<Integer> generate(int count) {
        return Randoms.pickUniqueNumbersInRange(startNum, endNum, count);
    }

}
