package lotto.common.convertor;

import java.util.List;
import java.util.stream.Stream;

public class StringConvertor {

    private StringConvertor() {
    }

    public static List<Integer> toIntegerList(String input, String delimiter) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

}
