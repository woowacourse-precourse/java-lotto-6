package lotto.util;

import lotto.model.Lotto;
import java.util.List;

public class CalculateMatch {

    private static int matchCount;
    private static boolean matchBonus;

    public static void dataReset(){
        matchCount = 0;
        matchBonus = false;
    }

    public static void calculateMatchCount(Lotto lotto, List<Integer> winningNumberList) {

        for (int number : lotto.getNumbers()) {
            if (winningNumberList.contains(number)) {
                matchCount++;
            }
        }

    }

}
