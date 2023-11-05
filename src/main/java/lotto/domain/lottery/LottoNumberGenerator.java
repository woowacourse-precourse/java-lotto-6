package lotto.domain.lottery;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.constants.LottoConstraint.*;

public class LottoNumberGenerator {

    public List<Integer> generateSortedLottoNumber() {
        List<Integer> numbers = new ArrayList<>(generateSingleLottoNumber());
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> generateSingleLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                NUMBER_RANGE_MINIMUM.getValue(),
                NUMBER_RANGE_MAXIMUM.getValue(),
                6
        );
    }
}