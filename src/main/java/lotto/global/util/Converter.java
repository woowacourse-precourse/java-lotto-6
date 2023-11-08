package lotto.global.util;

import java.util.Arrays;
import java.util.List;

public interface Converter {
    static Integer convertToNumber(String number) {
        return Integer.parseInt(number);
    }

    static List<Integer> covertToNumbers(String numbers) {
        String[] processedNumbers = numbers.split(",");
        return Arrays.stream(processedNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    static List<String> convertToStringNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
