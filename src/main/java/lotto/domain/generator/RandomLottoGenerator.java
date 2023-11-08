package lotto.domain.generator;

import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

import static lotto.common.LottoCount.LOTTO_COUNT_NUMBER;
import static lotto.common.LottoNumberRange.LOTTO_START_NUMBER;
import static lotto.common.LottoNumberRange.LOTTO_END_NUMBER;

public class RandomLottoGenerator implements LottoGeneratorImpl {
    @Override
    public List<Integer> generate() {
        return Randoms
                .pickUniqueNumbersInRange(LOTTO_START_NUMBER.getNumber(),
                        LOTTO_END_NUMBER.getNumber(),
                        LOTTO_COUNT_NUMBER)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
