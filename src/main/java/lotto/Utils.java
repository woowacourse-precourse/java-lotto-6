package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> convertStringToIntegerList(String commaSeparatedNumbers) {
        List<Integer> parsedNumbers = Arrays.stream(commaSeparatedNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return parsedNumbers;
    }

}
