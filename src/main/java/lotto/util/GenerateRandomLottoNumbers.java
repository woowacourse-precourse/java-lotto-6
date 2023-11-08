package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateRandomLottoNumbers implements RandomUtils {

    private static final int MIN_RANDOM_LOTTO_NUMBER = 1;
    private static final int MAX_RANDOM_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_LOTTO_NUMBER,
                MAX_RANDOM_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
