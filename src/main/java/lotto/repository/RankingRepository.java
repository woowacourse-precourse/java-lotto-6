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
import java.util.List;
import lotto.settings.WinningAmount;

public class RankingRepository {
    static List<List<String>> ranks = new ArrayList<>();

    public static void create(){
        int prizeSize = WinningAmount.size(); // 몇등까지 주는지
        for(int i=0; i<=prizeSize;i++){
            ranks.add(new ArrayList<>());
        }

        ranks.get(5).add(FIFTH_PLACE.getResult());
        ranks.get(5).add(FIFTH.getPrize());
        ranks.get(4).add(FOURTH_PLACE.getResult());
        ranks.get(4).add(FOURTH.getPrize());
        ranks.get(3).add(THIRD_PLACE.getResult());
        ranks.get(3).add(THIRD.getPrize());
        ranks.get(2).add(SECOND_PLACE.getResult());
        ranks.get(2).add(SECOND.getPrize());
        ranks.get(1).add(FIRST_PLACE.getResult());
        ranks.get(1).add(FIRST.getPrize());
    }

    public static List<String> getPrizeBy(int rank){
        return ranks.get(rank);
    }
}
