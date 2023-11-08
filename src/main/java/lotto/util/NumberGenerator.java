package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> generateOrderedNumbers() {
        List<Integer> randomNumbers = generateNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedNumbers);
        return randomNumbers;
    }

    private static List<Integer> generateNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
