package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
     public static List<Integer> getWinnerNumber(String inputWinnerNumber) {
         return splitAndParseToIntegers(removeBySpace(inputWinnerNumber));
    }

    private static String removeBySpace(String winnerNumbers){
        return winnerNumbers.replaceAll("\\s*,\\s*", ",");
    }

    private static List<Integer> splitAndParseToIntegers(String winnerNumbers) {
        return Stream.of(winnerNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
