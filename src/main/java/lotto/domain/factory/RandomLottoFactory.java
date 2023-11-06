package lotto.domain.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoNumber;

import java.util.List;

public class RandomLottoFactory implements LottoFactory {

    @Override
    public Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_NUMBER_RANGE,
                LottoNumber.MAX_NUMBER_RANGE,
                Lotto.LOTTO_NUMBERS_SIZE);

        return Lotto.from(numbers);
    }
}
