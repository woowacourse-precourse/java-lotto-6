package lotto.utils;

import java.util.List;

public class NumberHandler {

    public static List<Integer> numberMatches(List<Integer> firstNumbers, List<Integer> secondNumbers){
        return firstNumbers.stream()
                .distinct()
                .filter(secondNumbers::contains)
                .toList();
    }
}
