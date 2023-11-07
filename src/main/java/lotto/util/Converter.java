package lotto.util;

import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<Integer> stringToIntegerList(String str, String delimiter) {
        return Arrays.stream(str.split(delimiter))
                .map(numberStr -> {
                    try {
                        return Integer.parseInt(numberStr.trim());
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException(ErrorMessage.NOT_INTEGER);
                    }
                })
                .collect(Collectors.toList());
    }
}
