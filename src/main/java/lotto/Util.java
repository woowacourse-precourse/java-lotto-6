package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Util {
        public static List<String> toArrayList(String numString) {
                return new ArrayList<>(Arrays.asList(numString.split(Constants.DELIMITER)));
        }

        public static List<Integer> toInteger(List<String> numString) {
                return numString.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
}
