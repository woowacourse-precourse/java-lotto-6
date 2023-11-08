package lotto.generator;

import lotto.entity.PrizePrint;
import lotto.entity.WinMessage;
import lotto.service.FindNumInListService;

import java.util.List;

public class CalculateTotalProfit {

    public static int calculateTotalProfit(List<Integer> winCounts, int t) {
        int totalProfit = 0;
        int o = 3;
        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
            int count = FindNumInListService.countOccurrences(winCounts, o);
            int prize = PrizePrint.CalculatorPrize.calculatePrize(o);
            totalProfit += prize * count;
            o++;
        }
        return totalProfit;
    }
}
