package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Utilities {
    private static String COMMA_SEPARATOR = ",";

    public static int inputIntegerParsing(String input) {
        return Integer.parseInt(input);
    }

    public static double divide(double dividend, double divisor) {
            return dividend / divisor;
    }

    public static Set<String> inputNumberSet (String input) {
        String[] winningNumbers = input.split(COMMA_SEPARATOR);
        Set<String> inputNumber = new HashSet<>();
        Collections.addAll(inputNumber, winningNumbers);
        return inputNumber;
    }
}
