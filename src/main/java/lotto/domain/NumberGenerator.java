package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.util.LottoConstant.*;

public class NumberGenerator {

    private static List<Integer> NumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }

    public static Lotto createLottoNumber() {
        List<Integer> numbers = new ArrayList<>(NumberGenerator());

        numbers.sort(Comparator.naturalOrder());

        return new Lotto(numbers);
    }

}
