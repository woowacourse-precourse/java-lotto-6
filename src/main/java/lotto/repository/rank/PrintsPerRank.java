package lotto.repository.rank;

import static java.lang.String.format;
import static lotto.settings.WinningAmount.FIFTH;
import static lotto.settings.WinningAmount.FIRST;
import static lotto.settings.WinningAmount.FOURTH;
import static lotto.settings.WinningAmount.SECOND;
import static lotto.settings.WinningAmount.THIRD;

import java.util.HashMap;
import java.util.Map;

public class PrintsPerRank {
    private static final Map<Integer, String> printPerRank = new HashMap<>();
    public static void create(){
        printPerRank.put(5, format("3개 일치 (%s원) - ", FIFTH.getPrize()));
        printPerRank.put(4, format("4개 일치 (%s원) - ", FOURTH.getPrize()));
        printPerRank.put(3, format("5개 일치 (%s원) - ", THIRD.getPrize()));
        printPerRank.put(2, format("5개 일치, 보너스 볼 일치 (%s원) - ", SECOND.getPrize()));
        printPerRank.put(1, format("6개 일치 (%s원) - ", FIRST.getPrize()));
    }

    public static String getPrintBy(int rank){
        return printPerRank.get(rank);
    }
}
