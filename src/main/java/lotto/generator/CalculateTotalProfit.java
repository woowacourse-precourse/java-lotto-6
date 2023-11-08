package lotto.service;

import lotto.entity.PrizePrint;
import lotto.entity.WinMessage;

import java.util.List;

public class CalculateTotalProfit {

    public static int calculateTotalProfit(List<Integer> winCounts, int t) {
        int totalProfit = 0;
        int o = 3;
        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
            int count = NumCountInList.countOccurrences(winCounts, o);
            int prize = PrizePrint.CalculatorPrize.calculatePrize(o);
            totalProfit += prize * count;
            o++;
        }
        return totalProfit;
    }
}
