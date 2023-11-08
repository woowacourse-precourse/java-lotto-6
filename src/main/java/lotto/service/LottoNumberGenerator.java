package lotto.service;

import static lotto.constant.Number.LOTTO_MAX_NUM;
import static lotto.constant.Number.LOTTO_MIN_NUM;
import static lotto.constant.Number.LOTTO_NUM_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LOTTO_MIN_NUM.getNumber(),
                        LOTTO_MAX_NUM.getNumber(),
                        LOTTO_NUM_COUNT.getNumber()
                ).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
