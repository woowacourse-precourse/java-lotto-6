package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
