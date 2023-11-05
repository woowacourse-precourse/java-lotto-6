package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoInfo.MAX_NUMBER.getNumberInfo(),
                LottoInfo.MIN_NUMBER.getNumberInfo(),
                LottoInfo.MAX_SIZE.getNumberInfo());
    }
}
