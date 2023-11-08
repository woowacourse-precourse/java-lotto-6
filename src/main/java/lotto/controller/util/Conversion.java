package lotto.controller.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.controller.constant.ErrorConst.INPUT_NOT_INT;

public class Conversion {

    public static int makeInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INT, e);
        }
    }

    public static List<Integer> makeIntegerList(String input) {
        try {
            String[] inputSplit = input.split(",");
            return Arrays.stream(inputSplit)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INT, e);
        }
    }

}
