package lotto.service;

import lotto.entity.WinMessage;

import java.util.List;

public class PrintWinCounts {
    public static void printWinCounts(List<Integer> winCounts) {
        int o = 3;
        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
            int count = NumCountInList.countOccurrences(winCounts, o);
            System.out.println(winType.getLabel() + " - " + count + "개");
            o++;
        }
    }
}
