package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningCalculator { // 상금 계산기. 이상한 영어인가?
    private static final Map<Prize, Integer> prizeCountMap = new LinkedHashMap<>();

    static {
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }
    }

    private WinningCalculator() {
        throw new IllegalArgumentException();
    }

    public static void addCount(Prize prize){
        prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
    }

    public static Map<Prize, Integer> getPrizeCountMap(){
        return new LinkedHashMap<>(prizeCountMap);
    }

    public static long getTotalWinning() {
        return prizeCountMap.entrySet().stream()
                .map(entry -> entry.getKey().getWinning() * entry.getValue())
                .mapToLong(Long::valueOf)
                .sum();
    }
}