package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoFactory implements LottoFactory {
    @Override
    public Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MINIMUM_VALUE,
                LottoNumber.MAXIMUM_VALUE,
                Lotto.LOTTO_NUMBER_LENGTH
        );
        return new Lotto(numbers);
    }
}
