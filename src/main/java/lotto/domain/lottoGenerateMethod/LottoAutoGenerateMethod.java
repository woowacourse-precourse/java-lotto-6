package lotto.domain.lottoGenerateMethod;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class LottoAutoGenerateMethod implements LottoGenerateMethod {

    @Override
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.START_INCLUSIVE,
                Lotto.END_INCLUSIVE,
                Lotto.LOTTO_SIZE
        );
        return Lotto.of(numbers);
    }
}
