package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.Config;

public final class NumberGenerator {
    public static List<Integer> generateSortedNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Config.MIN_LOTTO_NUMBER, Config.MAX_LOTTO_NUMBER,
                Config.LOTTO_NUMBER_SIZE);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
