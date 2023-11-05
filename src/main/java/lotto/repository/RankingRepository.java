package lotto.repository;

import static lotto.settings.WinningAmount.FIFTH;
import static lotto.settings.WinningAmount.FIRST;
import static lotto.settings.WinningAmount.FOURTH;
import static lotto.settings.WinningAmount.SECOND;
import static lotto.settings.WinningAmount.THIRD;
import static lotto.settings.WinningSettings.FIFTH_PLACE;
import static lotto.settings.WinningSettings.FIRST_PLACE;
import static lotto.settings.WinningSettings.FOURTH_PLACE;
import static lotto.settings.WinningSettings.SECOND_PLACE;
import static lotto.settings.WinningSettings.THIRD_PLACE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.settings.WinningAmount;

public class RankingRepository {
    static Map<Integer, String> ranksMap = new HashMap<>();
    public static void create(){
        ranksMap.put(5,FIFTH_PLACE.getResult());
        ranksMap.put(4,FOURTH_PLACE.getResult());
        ranksMap.put(3,THIRD_PLACE.getResult());
        ranksMap.put(2,SECOND_PLACE.getResult());
        ranksMap.put(1,FIRST_PLACE.getResult());
    }
    public static String getPrizeBy(int rank){
        return ranksMap.get(rank);
    }
}
