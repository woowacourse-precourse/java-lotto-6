package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer COUNT = 6;

    public static List<Integer> run() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        randomNumbers = sortRandomNumber(randomNumbers);
        return randomNumbers;
    }

    private static List<Integer> sortRandomNumber(List<Integer> randomNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
