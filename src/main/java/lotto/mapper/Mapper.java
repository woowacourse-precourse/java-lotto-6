package lotto.mapper;

import java.util.Arrays;
import java.util.List;

public class Mapper {

    public List<Integer> stringToIntegerList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
