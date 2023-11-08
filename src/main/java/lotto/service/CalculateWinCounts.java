package lotto.service;

import lotto.entity.WinCount;

import java.util.ArrayList;
import java.util.List;

public class CalculateWinCounts {
    public static List<Integer> calculateWinCounts(List<List<Integer>> lottoNumberList, List<Integer> lottoWinNumber, int bonusNumber) {
        List<Integer> winCounts = new ArrayList<>();
        for (List<Integer> compareList : lottoNumberList) {
            int winCount = WinCount.calculateWinCount(compareList, lottoWinNumber, bonusNumber);
            winCounts.add(winCount);
        }
        return winCounts;
    }
}
