package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class Utills {

    public static int stringToInteger(String input) {
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> sortListAscending(List<Integer> numbers) {
        List<Integer> unSortedNumbers = new ArrayList<>(numbers);
        unSortedNumbers.sort(Integer::compareTo);
        return unSortedNumbers;
    }

    public static List<Integer> randomUniqueNumbers(int count, int min, int max) {
        return Randoms.pickUniqueNumbersInRange(count, min, max);
    }
}
