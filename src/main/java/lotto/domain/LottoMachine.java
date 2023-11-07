package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    public Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER, Lotto.NUM_OF_LOTTO);
        return new Lotto(numbers);
    }
}
