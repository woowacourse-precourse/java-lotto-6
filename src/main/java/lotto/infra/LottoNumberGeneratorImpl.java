package lotto.infra;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {
    private static final int LOTTO_NUMBER_LEN = 6;
    @Override
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);

        return new Lotto(numbers);
    }
}
