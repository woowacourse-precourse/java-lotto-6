package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class LottoNumberGenerator {

    private static final int MINIMUM_NUMBER_OF_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_NUMBER_OF_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int ZERO = 0;

    public static List<List<Integer>> generateRandomNumbers(long count) {
        List<List<Integer>> randomLottoNumbers = new ArrayList<>();

        LongStream.range(ZERO, count)
            .forEach(index -> {
                List<Integer> randomNumbers = new ArrayList<>(pickUniqueNumbersInRange());
                randomNumbers.sort(Integer::compareTo);
                randomLottoNumbers.add(randomNumbers);
            });

        return randomLottoNumbers;
    }

    private static List<Integer> pickUniqueNumbersInRange() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
            MINIMUM_NUMBER_OF_LOTTO_NUMBER,
            MAXIMUM_NUMBER_OF_LOTTO_NUMBER, LOTTO_SIZE);
        return randomNumbers;
    }
}
