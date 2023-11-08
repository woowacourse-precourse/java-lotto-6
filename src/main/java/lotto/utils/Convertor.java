package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    public static List<Integer> winningToList(String winning) {
        List<Integer> winningNumbers = Arrays.stream(winning.split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();
        return winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    public static String numToStatus(int matchingNum) {
        return Constant.lottoResult.get(matchingNum);
    }
}
