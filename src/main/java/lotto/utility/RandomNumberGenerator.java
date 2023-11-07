package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.configuration.RandomNumberConfig.*;

public class RandomNumberGenerator {
    public static List<Integer> generateNotDuplicatedRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
