package lotto.utils;

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
}
