package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.global.constant.NumberDefinition.*;

public class NumberGenerator implements NumberUtil {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.getNumber(), END_INCLUSIVE.getNumber(), LOTTO_NUMBER_COUNT.getNumber());
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
