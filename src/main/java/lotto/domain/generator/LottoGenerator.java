package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoGenerator {

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_RANGE_BEGIN, Lotto.LOTTO_RANGE_END, Lotto.LOTTO_NUMBER)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
