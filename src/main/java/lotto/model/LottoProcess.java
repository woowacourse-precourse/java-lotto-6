package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoProcessException;

public class LottoProcess {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBERS_SIZE = 6;
    private static final int NUMBERS_MIN_RANGE = 1;
    private static final int NUMBERS_MAX_RANGE = 45;

    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(NUMBERS_MIN_RANGE, NUMBERS_MAX_RANGE, NUMBERS_SIZE);
        return new Lotto(randomNumbers);
    }


}
