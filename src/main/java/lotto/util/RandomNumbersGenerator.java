package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoInfo.MIN_NUMBER.getNumberInfo(),
                LottoInfo.MAX_NUMBER.getNumberInfo(),
                LottoInfo.MAX_SIZE.getNumberInfo());

        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
