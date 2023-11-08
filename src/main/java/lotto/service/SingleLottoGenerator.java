package lotto.service;

import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.lotto.Lotto;

public abstract class SingleLottoGenerator {

    private SingleLottoGenerator() {
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,
                        LOTTO_END_NUMBER,
                        LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();

        return Lotto.of(numbers);
    }
}
