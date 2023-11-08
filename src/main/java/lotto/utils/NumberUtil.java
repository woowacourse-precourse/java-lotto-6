package lotto.utils;

import java.util.List;

public class NumberUtil {

    private static final String DELIMITER = ",";

    public static int toLottoCount(int purchaseAmount, final int lottoPrice) {
        return purchaseAmount / lottoPrice;
    }

    public static List<Integer> toListInteger(String inputNumbers) {
        List<String> winningNumbers = List.of(inputNumbers.split(DELIMITER));
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
