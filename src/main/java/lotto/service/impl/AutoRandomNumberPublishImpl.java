package lotto.service.impl;

import static lotto.config.LottoCount.LOTTO_COUNT;
import static lotto.config.LottoNumberRange.MAX_LOTTO_NUMBER;
import static lotto.config.LottoNumberRange.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.config.LottoNumberRange;
import lotto.service.Publish;

public class AutoRandomNumberPublishImpl implements Publish {
    @Override
    public List<Integer> makeNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getNumber(),
                MAX_LOTTO_NUMBER.getNumber(),
                LOTTO_COUNT.getCount()
        );
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
