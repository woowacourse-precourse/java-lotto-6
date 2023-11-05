package lotto.domain.lottery.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.domain.constants.LottoConstraint.*;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static List<Integer> generateLottoNumbers() {
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
