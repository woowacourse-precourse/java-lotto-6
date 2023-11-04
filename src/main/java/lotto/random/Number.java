package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Number {

    public static List<List<Integer>> lottoGenerator(int lottoNumber) {
        return IntStream.range(0, lottoNumber)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .collect(Collectors.toList());
    }
}
