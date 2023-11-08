package lotto.util;

import static lotto.util.AscendingSorter.sortAscending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberSplitter {
    private static final String LOTTO_NUMBERS_SPLIT_DELIM = ",";
    public static List<Integer> splitNumbers(String input) {
        String[] numberSplit = input.split(LOTTO_NUMBERS_SPLIT_DELIM);
        List<Integer> numberList = new ArrayList<>();

        for (String number : numberSplit) {
            numberList.add(IntParser.parseInt(number));
        }
        return numberList;
    }
}
