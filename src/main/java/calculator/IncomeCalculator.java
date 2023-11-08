package calculator;

import lotto.Prize;

import java.util.LinkedHashMap;
import java.util.Map;

public class IncomeCalculator { // 상금 계산기. 이상한 영어인가?
    private final Map<Prize, Integer> prizeCountMap = new LinkedHashMap<>();


    public IncomeCalculator() {
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }
    }

    public void clear(){
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }
    }


    public void addCount(Prize prize){
        prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
    }

    public Map<Prize, Integer> getPrizeCountMap(){
        return new LinkedHashMap<>(prizeCountMap);
    }

    public long getTotalIncome() {
        long totalIncome = prizeCountMap.entrySet().stream()
                .map(entry -> (long) entry.getKey().getWinning() * entry.getValue())
                .mapToLong(Long::valueOf)
                .sum();
        clear();
        return totalIncome;
    }
}