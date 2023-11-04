package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;

public class PrizeManager {
    private List<Integer> prizes = new ArrayList<>();

    public void checkTicketAndAddPrizes(List<Integer> points) {
        for (int point : points) {
            int prize = Rank.getPrizeByPoint(point);
            prizes.add(prize);
        }
    }


    // testcode
    protected List<Integer> getPrizes() {
        return prizes;
    }

}
