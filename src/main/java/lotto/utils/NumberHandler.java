package lotto.utils;

import java.util.List;

public class NumberHandler {

    public List<Integer> numberMatches(List<Integer> numbers1, List<Integer> numbers2){
        return numbers1.stream()
                .distinct()
                .filter(numbers2::contains)
                .toList();
    }
}
