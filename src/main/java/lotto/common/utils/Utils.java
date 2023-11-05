package lotto.common.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.constants.Symbol;

public class Utils {
    public List<String> stringToStringList(String inputString) {
        return Arrays.stream(inputString.split(Symbol.COMMA.getSymbol()))
                .map(String::trim)
                .toList();
    }

    public List<Integer> stringListToIntegerList(List<String> inputStringList) {
        return inputStringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
