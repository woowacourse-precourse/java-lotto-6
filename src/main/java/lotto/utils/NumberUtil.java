package lotto.utils;

import java.util.List;
import lotto.constant.UtilsConstant;

public class NumberUtil {

    public static int toLottoCount(int purchaseAmount, final int lottoPrice) {
        return purchaseAmount / lottoPrice;
    }

    public static List<Integer> toListInteger(String inputNumbers) {
        List<String> winningNumbers = List.of(inputNumbers.split(UtilsConstant.DELIMITER.getString()));
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
