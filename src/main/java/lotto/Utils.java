package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static boolean hasDuplicates(List<Integer> numbers) {
        long totalNumber = numbers.stream().distinct().count();
        long sizeOfNumbers = numbers.size();

        return totalNumber == sizeOfNumbers;
    }

    public static int getRemainder(int number, int divisor) {
        return number % divisor;
    }

    public static List<String> split(String input, String DELIMITER) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static List<Integer> convertToIntegers(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static List<Integer> getRandomNumbers(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
