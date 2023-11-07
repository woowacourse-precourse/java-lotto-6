package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGeneratorUtil {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> randomNumbersGenerate() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_SIZE));
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers);
        return randomNumbers;
    }
}