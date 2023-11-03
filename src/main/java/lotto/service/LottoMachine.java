package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_LENGTH = 6;

    private LottoMachine() { }

    public static Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_LENGTH);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
