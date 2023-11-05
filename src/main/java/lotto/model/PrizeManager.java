package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;

public class PrizeManager {
    // Fields
    private List<Integer> prizes = new ArrayList<>();
    private final int TICKET_PRICE = 1000;


    // Features
    // 입력받은 점수 목록을 토대로 Rank로부터 상금 목록을 생성한다.
    public void calculatePrizesByPoints(List<Integer> points) {
        for (int point : points) {
            int prize = Rank.getPrizeByPoint(point);
            prizes.add(prize);
        }
    }

    // a-3.각 등수에 해당하는 티켓 수를 반환한다.
    public List<Integer> getEachPrizeCounts() {
        List<Integer> counts = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        calculatePrizeCounts(counts);

        return counts;
    }

    public double getProfitRatio() {
        double totalPrize = calculateTotalPrize();
        double totalCost = TICKET_PRICE * prizes.size();
        double ratio = totalPrize / totalCost * 100.0;
        double value = Math.round(ratio * 100.0) / 100.0;

        return value;
    }


    // Internal Implements
    private int calculateTotalPrize() {
        int total = 0;
        for (int prize : prizes) {
            total += prize;
        }

        return total;
    }

    // a-2.파라미터로 받은 배열에 상금 별 index의 개수(=등수별 티켓 수)를 저장한다.
    private void calculatePrizeCounts(List<Integer> counts) {
        List<Integer> indexes = getIndexOfAllPrizes();

        for (int index : indexes) {
            if (index != -1) {
                int want = counts.get(index) + 1;
                counts.set(index, want);
            }
        }
    }

    // a-1.필드 변수인 상금 배열을 토대로 Rank로부터 상금 별 index로 이루어진 리스트를 반환한다.
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
