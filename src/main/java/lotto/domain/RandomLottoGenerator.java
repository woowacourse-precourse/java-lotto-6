package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.NumberService;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public List<Integer> create(int size) {
        return Randoms.pickUniqueNumbersInRange(NumberService.LOTTO_RANGE_MIN, NumberService.LOTTO_RANGE_MAX, size);
    }
}
