package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoGameUtil {
    public static int StringToInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> StringArrayToList(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).boxed().toList();
    }

}
