package lotto;

import java.util.List;

public class StringConverter {
    public List<Integer> convertToIntegerList(List<String> numbers){
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
