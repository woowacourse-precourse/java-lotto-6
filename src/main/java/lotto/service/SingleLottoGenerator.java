package lotto.service;

import static lotto.service.LottoConstant.LOTTO_END_NUMBER;
import static lotto.service.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.service.LottoConstant.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class SingleLottoGenerator {

    public List<Integer> generate() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER))
                .distinct()
                .limit(LOTTO_NUMBER_COUNT)
                .boxed()
                .sorted()
                .toList();
    }
}
