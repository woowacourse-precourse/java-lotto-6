package domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

import static global.NumberDefinition.*;

public class NumberGenerator implements NumberUtil {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.getNumber(), END_INCLUSIVE.getNumber(), LOTTO_NUMBER_COUNT.getNumber());
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }
}
