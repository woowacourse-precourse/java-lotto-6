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

    public List<Integer> getPrizeCounts() {
        List<Integer> counts = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        calculatePrizeCounts(counts);

        return counts;
    }


    private void calculatePrizeCounts(List<Integer> counts) {
        List<Integer> indexes = getIndexOfAllPrizes();

        for (int index : indexes) {
            if (index != -1) {
                int want = counts.get(index) + 1;
                counts.set(index, want);
            }
        }
    }

    private List<Integer> getIndexOfAllPrizes() {
        List<Integer> indexes = new ArrayList<>();
        for (int prize : prizes) {
            int index = Rank.getIndexByPrize(prize);
            indexes.add(index);
        }
        return indexes;
    }

    // testcode
    protected List<Integer> getPrizes() {
        return prizes;
    }

}
