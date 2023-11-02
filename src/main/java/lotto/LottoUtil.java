package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    public static List<Integer> parseNumberToListInteger(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
