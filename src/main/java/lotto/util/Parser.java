package lotto.util;


import static java.lang.Integer.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private Parser() {
    }

    public static Integer parseLottoPurchaseAmount(String lottoPurchaseAmount) {
        return parseInt(lottoPurchaseAmount);
    }

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer parseBonusNumber(String bonusNumber) {
        return parseInt(bonusNumber);
    }
}
