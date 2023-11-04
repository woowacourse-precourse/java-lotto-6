package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public abstract class LottoMachine {
    private static final int LOWER_LIMIT_NUMBER = 1;
    private static final int UPPER_LIMIT_NUMBER = 45;
    private static final int NUMBER_QUANTITY = 6;

    public static Lotto issueAutomaticLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LOWER_LIMIT_NUMBER, UPPER_LIMIT_NUMBER, NUMBER_QUANTITY
        );
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    public static Lotto issueManualLotto(List<Integer> manualNumbers) {
        Collections.sort(manualNumbers);
        return new Lotto(manualNumbers);
    }

}
