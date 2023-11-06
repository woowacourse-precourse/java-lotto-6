package lotto.repository;

import static lotto.settings.WinningSettings.FIFTH_PLACE;
import static lotto.settings.WinningSettings.FIRST_PLACE;
import static lotto.settings.WinningSettings.FOURTH_PLACE;
import static lotto.settings.WinningSettings.SECOND_PLACE;
import static lotto.settings.WinningSettings.THIRD_PLACE;

import java.util.HashMap;
import java.util.Map;

public class RankingRepository {
    static Map<Integer, String> prizePerRank = new HashMap<>();
    public static void create(){
        prizePerRank.put(5,FIFTH_PLACE.getResult());
        prizePerRank.put(4,FOURTH_PLACE.getResult());
        prizePerRank.put(3,THIRD_PLACE.getResult());
        prizePerRank.put(2,SECOND_PLACE.getResult());
        prizePerRank.put(1,FIRST_PLACE.getResult());
    }
    public static String getPrizeBy(int rank){
        return prizePerRank.get(rank);
    }
}
