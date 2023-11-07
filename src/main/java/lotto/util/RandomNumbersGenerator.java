package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoInfo.MIN_NUMBER.getNumberInfo(),
                LottoInfo.MAX_NUMBER.getNumberInfo(),
                LottoInfo.MAX_SIZE.getNumberInfo());

        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
