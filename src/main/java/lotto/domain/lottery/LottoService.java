package lotto.domain.lottery;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.domain.lottery.constants.LottoConstraint.*;

public class LottoService {
    private LottoService() {
    }

    public static List<Integer> generateOrderedLottoNumbers() {
        List<Integer> randomNumbers = generateLottoNumber();
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                NUMBER_LOWER_BOUND.getValue(),
                NUMBER_UPPER_BOUND.getValue(),
                LOTTO_PICK_COUNT.getValue()
        );
    }
}
