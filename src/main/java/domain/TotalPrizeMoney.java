package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class TotalPrizeMoney {
    public float totalPrizeMoneyService(Map<String, Integer> resultsCount, int inputMoney) {
        // 등수별 당첨금 매핑
        Map<String, Long> prizeMap = new LinkedHashMap<>();
        prizeMap.put("6개 일치 (2,000,000,000원)", 2_000_000_000L);
        prizeMap.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L);
        prizeMap.put("5개 일치 (1,500,000원)", 1_500_000L);
        prizeMap.put("4개 일치 (50,000원)", 50_000L);
        prizeMap.put("3개 일치 (5,000원)", 5_000L);

        long totalPrize = 0L; // 총 당첨금

        for (Map.Entry<String, Integer> entry : resultsCount.entrySet()) {
            String key = entry.getKey();
            Integer count = entry.getValue();
            Long prize = prizeMap.getOrDefault(key, 0L);
            totalPrize += prize * count; // 각 등수별 당첨금을 총액에 더한다
        }

        return ((float) (totalPrize * 100) /  inputMoney); // 총 당첨금 반환
    }


}
