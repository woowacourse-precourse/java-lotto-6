package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LIST_SIZE = 6;

    @Override
    public List<Integer> generateSortedList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LIST_SIZE);
        return getSortedNumbers(numbers);
    }

    private List<Integer> getSortedNumbers(final List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
