package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.configuration.RandomNumberConfig.*;

public class RandomNumberGenerator {
    public static List<Integer> generateNotDuplicatedRandomNumbersOrderByAsc() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
