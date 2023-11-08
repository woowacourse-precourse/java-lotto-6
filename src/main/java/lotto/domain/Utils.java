package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

    public static int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static List<Integer> stringToIntegerList(String string) {
        Validations.validateListParseInt(Arrays.asList(string.split(",")));
        return Arrays.stream(stringToIntArray(string))
                .boxed()
                .collect(Collectors.toList());
    }

    public static int stringToInteger(String string) {
        Validations.validateParseInt(string);
        return Integer.parseInt(string);
    }

    public static List<Integer> ascendingOrder(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<>(list);
        Collections.sort(orderedList);
        return orderedList;
    }

    public static int countSameNumber(List<Integer> list, int number) {
        if (list.contains(number)) {
            return LottoInfoNumbers.ONE;
        }
        return LottoInfoNumbers.ZERO;
    }

    public static int countMatchNumbers(List<Integer> winningNumbers, List<Integer> userNumbers) {
        int count = LottoInfoNumbers.ZERO;
        for (Integer userNumber : userNumbers) {
            count += countSameNumber(winningNumbers, userNumber);
        }
        return count;
    }

}
