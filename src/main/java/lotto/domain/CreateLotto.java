package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateLotto {

    private final static int LOTTO_LENGTH = 6;
    private final static int LOTTO_NUM_MIN_RANGE = 1;
    private final static int LOTTO_NUM_MAX_RANGE = 45;

    public List<List<Integer>> createLotto(int lottoCounts) {
        return IntStream.range(0, lottoCounts)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(LOTTO_NUM_MIN_RANGE, LOTTO_NUM_MAX_RANGE, LOTTO_LENGTH))
                .map(numbers -> {
                    numbers.sort(Integer::compareTo);
                    System.out.println(numbers);
                    return numbers;
                })
                .collect(Collectors.toList());
    }

}
