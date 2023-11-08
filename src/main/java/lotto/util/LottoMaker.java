package lotto.util;

import static lotto.global.Configuration.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE_VALUE.getValue(),
                MAXIMUM_RANGE_VALUE.getValue(), PICK_COUNT.getValue());

        Collections.sort(new ArrayList<>(numbers));

        return numbers;
    }
}
