package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateSortedList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return getSortedNumbers(numbers);
    }

    private List<Integer> getSortedNumbers(final List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
