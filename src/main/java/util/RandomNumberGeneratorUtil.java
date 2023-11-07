package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomNumberGeneratorUtil {
    public List<Integer> randomNumbersGenerate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers);
        return randomNumbers;
    }
}