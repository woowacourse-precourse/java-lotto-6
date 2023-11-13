package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number {
    public List<Integer> createNumbers(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_COUNT_NUMBER));
        Collections.sort(numbers);
        return numbers;
    }
}
