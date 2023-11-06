package lotto.repository.rank;

import static lotto.settings.WinningSettings.FIFTH_PLACE;
import static lotto.settings.WinningSettings.FIRST_PLACE;
import static lotto.settings.WinningSettings.FOURTH_PLACE;
import static lotto.settings.WinningSettings.SECOND_PLACE;
import static lotto.settings.WinningSettings.THIRD_PLACE;

import java.util.HashMap;
import java.util.Map;

public class PrintsPerRank {
    private static final Map<Integer, String> printPerRank = new HashMap<>();
    public static void create(){
        printPerRank.put(5,FIFTH_PLACE.getResult());
        printPerRank.put(4,FOURTH_PLACE.getResult());
        printPerRank.put(3,THIRD_PLACE.getResult());
        printPerRank.put(2,SECOND_PLACE.getResult());
        printPerRank.put(1,FIRST_PLACE.getResult());
    }
    public static String getPrintBy(int rank){
        return printPerRank.get(rank);
    }
}
