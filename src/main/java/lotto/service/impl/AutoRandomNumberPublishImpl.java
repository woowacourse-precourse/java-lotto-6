package lotto.service.impl;

import static lotto.config.LottoConfig.LOTTO_COUNT;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.service.Publish;

public class AutoRandomNumberPublishImpl implements Publish {
    @Override
    public List<Integer> makeNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getNum(),
                MAX_LOTTO_NUMBER.getNum(),
                LOTTO_COUNT.getNum()
        );
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
