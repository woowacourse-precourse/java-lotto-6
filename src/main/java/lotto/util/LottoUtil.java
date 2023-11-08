package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ErrorView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    public static List<Integer> generateRandomNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static List<Integer> sortNumbersAscending(List<Integer> numbers) {
        List<Integer> orderedList = new ArrayList<Integer>(numbers);
        Collections.sort(orderedList);
        return orderedList;
    }

    public static List<Integer> parseNumbersFromString(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorView.getInvalidInputFormatErrorMessage());
        }
    }
}
