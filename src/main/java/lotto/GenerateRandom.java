package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GenerateRandom {

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
