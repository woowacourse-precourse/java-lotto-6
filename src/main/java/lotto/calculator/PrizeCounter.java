package lotto.calculator;

import static lotto.view.OutputView.PRIZE;
import static lotto.view.OutputView.WINNING_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.WinningPrize;

public class PrizeCounter {
    private Map<String, Integer> counter = new HashMap<>();

    public void setCounter() {
        counter.put("FIRST_PLACE", 0);
        counter.put("SECOND_PLACE", 0);
        counter.put("THIRD_PLACE", 0);
        counter.put("FOURTH_PLACE", 0);
        counter.put("FIFTH_PLACE", 0);
    }

    private PrizeCalculator prizeCalculator;
    private List<WinningPrize> prizes = new ArrayList<>();

    public PrizeCounter(PrizeCalculator prizeCalculator) {
        this.prizes = prizeCalculator.getPrizes();
    }

    public Map<String, Integer> countPrize(List<WinningPrize> prizes) {
        setCounter();
        WinningPrize winningPrize;

        //PRIZE 이용하여 개수 찾기
        for (int i=0; i<prizes.size(); i++) {
            winningPrize = prizes.get(i);
            counter.put(winningPrize.name(), counter.get(winningPrize.name())+1);
        }
        return counter;
    }
}
