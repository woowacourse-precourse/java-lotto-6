package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.LottoNumberRange;

public class Computer {
    public List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoNumberRange.MIN_NUMBER.getValue(),
                LottoNumberRange.MAX_NUMBER.getValue(), LottoNumberRange.MIN_SELECT_COUNT.getValue()));
        return sortNumber(numbers);
    }

    public List<Integer> sortNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
