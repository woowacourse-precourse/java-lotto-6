package lotto.util;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.CommonLetter;

public class Parser {
    public static int parseToInt(String input) {
        return Integer.parseInt(input);
    }

    public static BitSet parseToBitSet(List<Integer> numbers){
        BitSet bitSet = new BitSet();
        for (int number : numbers) {
            bitSet.set(number);
        }
        return bitSet;
    }

    public static List<Integer> parseToIntegerList(String unConvertedNumbers) {
        return Arrays.stream(unConvertedNumbers.split(CommonLetter.SEPARATOR.getLetter()))
            .map(Parser::parseToInt)
            .collect(Collectors.toList());
    }

    public static String parseToString(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(CommonLetter.SEPARATOR.getLetter()));
    }
}
