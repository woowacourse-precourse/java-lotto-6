package lotto.domain;

import static lotto.domain.LottoValue.LOTTO_RANGE_IN_END_VALUE;
import static lotto.domain.LottoValue.LOTTO_RANGE_IN_START_VALUE;
import static lotto.domain.LottoValue.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoCreate {

    public List<Lotto> generateRandomLotto(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> generateRangeOfUniqueNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Integer> generateRangeOfUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_IN_START_VALUE,
                LOTTO_RANGE_IN_END_VALUE,
                LOTTO_SIZE);
    }
}
