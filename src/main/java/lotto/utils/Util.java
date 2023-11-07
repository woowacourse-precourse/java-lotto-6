package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<Integer> stringToIntegerList(String[] string) {
        return Arrays.stream(string)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_SIZE);
    }
}
