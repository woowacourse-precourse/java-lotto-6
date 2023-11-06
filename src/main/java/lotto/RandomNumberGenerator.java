package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RandomNumberGenerator {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int count = 6;


    public List<Integer> generateUniqueAndRandomSixNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
        return sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }


}
