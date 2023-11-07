package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> run() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        while (validateDuplicate(randomNumbers)) {
            randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        randomNumbers = sortRandomNumber(randomNumbers);
        return randomNumbers;
    }

    private static List<Integer> sortRandomNumber(List<Integer> number) {
        List<Integer> sortedNumbers = new ArrayList<>(number);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private static Boolean validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : numbers) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
