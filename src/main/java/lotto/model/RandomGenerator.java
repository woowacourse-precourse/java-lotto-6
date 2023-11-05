package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class RandomGenerator {
    public List<Integer> createUniqueNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
