package lotto.domain;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoTicket generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return new LottoTicket(lotto);
    }
}
