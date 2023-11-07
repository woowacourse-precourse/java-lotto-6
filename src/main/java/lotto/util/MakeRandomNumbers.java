package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class MakeRandomNumbers {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int SIZE = 6;

    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
