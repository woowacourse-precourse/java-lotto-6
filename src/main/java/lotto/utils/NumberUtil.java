package lotto.utils;

import java.util.List;

public class NumberUtil {

    private static final String DELIMITER = ",";

    public static int toLottoCount(final String purchaseAmount, final int lottoPrice) {
        int amount = Integer.parseInt(purchaseAmount);
        return amount / lottoPrice;
    }

    public static List<Integer> toListInteger(String inputNumbers) {
        List<String> winningNumbers = List.of(inputNumbers.split(DELIMITER));
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
