package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class LottoNumberGenerator {

    public static List<List<Integer>> generateRandomNumbers(long count) {

        List<List<Integer>> randomLottoNumbers = new ArrayList<>();

        LongStream.range(0, count)
            .forEach(i -> {
                List<Integer> randomNumbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
                randomNumbers.sort(Integer::compareTo);
                randomLottoNumbers.add(randomNumbers);
            });

        return randomLottoNumbers;
    }
}
