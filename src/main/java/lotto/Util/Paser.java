package lotto.Util;

import java.util.ArrayList;
import java.util.List;

import static lotto.Util.Validate.validateTypeInt;

public class Paser {
    private static List<Integer> winningNumberPaser;
    public static List<Integer> createWinningLotto(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberPaser = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberPaser.add(validateTypeInt(result[i]));
        }
        return winningNumberPaser;
    }
}
