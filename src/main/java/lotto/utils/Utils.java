package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class Utils {

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> sortListAscending(List<Integer> numbers) {
        List<Integer> unSortedNumbers = new ArrayList<>(numbers);
        unSortedNumbers.sort(Integer::compareTo);
        return unSortedNumbers;
    }

    public static List<Integer> randomUniqueNumbers(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
