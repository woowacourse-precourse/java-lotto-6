package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public List<List<Integer>> getRandomNumbers(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return result;
    }
}
