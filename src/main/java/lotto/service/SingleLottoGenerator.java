package lotto.service;

import static lotto.service.LottoConstant.LOTTO_END_NUMBER;
import static lotto.service.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.service.LottoConstant.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.number.Lotto;

public class SingleLottoGenerator {

    public Lotto generate() {
        List<Integer> numbers = IntStream.generate(
                        () -> Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER))
                .distinct()
                .limit(LOTTO_NUMBER_COUNT)
                .boxed()
                .sorted()
                .toList();

        return new Lotto(numbers);
    }
}
