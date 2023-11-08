package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utils {
    private Utils() {
    }

    public static List<Integer> generateRandomLottoNumbers(int minimumNumber, int maximumNumber, int number) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumNumber, maximumNumber, number);
        numbers = numbers.stream()
                .sorted()
                .toList();
        return numbers;
    }

}
