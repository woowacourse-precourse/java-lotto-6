package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<MatchMode, Integer> resultMap;

    public Statistics() {
        this.resultMap = initResultMap();
    }

    public void printMatchResult(List<Integer> count, boolean isContain, int lottery) {
        Map<MatchMode, Integer> createResultMap = createResultMap(count, isContain);

        for (Map.Entry<MatchMode, Integer> entry : createResultMap.entrySet()) {
            MatchMode mode = entry.getKey();
            int matchCount = entry.getValue();

            System.out.println(mode.description + " - " + matchCount + "개");
        }

        getRate(createResultMap, lottery);

    }

    private Map<MatchMode, Integer> createResultMap(List<Integer> count, boolean isContain) {

        for (int matchingCount : count) {
            if (matchingCount == 3) {
                int updatedValue = resultMap.get(MatchMode.THREE_NUMBER_MATCH) + 1;
                resultMap.replace(MatchMode.THREE_NUMBER_MATCH, updatedValue);
            }

            if (matchingCount == 4) {
                int updatedValue = resultMap.get(MatchMode.FOUR_NUMBER_MATCH) + 1;
                resultMap.replace(MatchMode.FOUR_NUMBER_MATCH, updatedValue);
            }

            if (matchingCount == 5) {
                if (isContain) {
                    int updatedValue = resultMap.get(MatchMode.FIVE_NUMBER_MATCH) + 1;
                    resultMap.replace(MatchMode.FIVE_NUMBER_MATCH, updatedValue);
                }
                if (!isContain) {
                    int updatedValue = resultMap.get(MatchMode.FIVE_NUMBER_MATCH_WITH_BONUS) + 1;
                    resultMap.replace(MatchMode.FIVE_NUMBER_MATCH_WITH_BONUS, updatedValue);
                }
            }

            if (matchingCount == 6) {
                int updatedValue = resultMap.get(MatchMode.SIX_NUMBER_MATCH) + 1;
                resultMap.replace(MatchMode.SIX_NUMBER_MATCH, updatedValue);
            }

        }

        return resultMap;
    }

    private Map<MatchMode, Integer> initResultMap() {
        Map<MatchMode, Integer> resultMap = new EnumMap<>(MatchMode.class);
        resultMap.put(MatchMode.THREE_NUMBER_MATCH, 0);
        resultMap.put(MatchMode.FOUR_NUMBER_MATCH, 0);
        resultMap.put(MatchMode.FIVE_NUMBER_MATCH, 0);
        resultMap.put(MatchMode.FIVE_NUMBER_MATCH_WITH_BONUS, 0);
        resultMap.put(MatchMode.SIX_NUMBER_MATCH, 0);

        return resultMap;
    }

    private void getRate(Map<MatchMode, Integer> createResultMap, int lottery) {
        int totalPrize = 0;
        for (Map.Entry<MatchMode, Integer> entry : createResultMap.entrySet()) {
            if (entry.getValue() != 0) {
                totalPrize += entry.getKey().prize;
            }
        }

        double profitPercentage = Math.round(((double) (totalPrize / lottery) * 100)) / 1000.0;
        System.out.println("총 수익률은 " + profitPercentage + "%입니다.");
    }


    public enum MatchMode {
        THREE_NUMBER_MATCH("3개 일치 (5,000원)", 5_000),
        FOUR_NUMBER_MATCH("4개 일치 (50,000원)", 50_000),
        FIVE_NUMBER_MATCH("5개 일치 (1,500,000원)", 1_500_000),
        FIVE_NUMBER_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
        SIX_NUMBER_MATCH("6개 일치 (2,000,000,000원)", 2_000_000_000);

        private final String description;
        private final int prize;

        MatchMode(String description, int prize) {
            this.description = description;
            this.prize = prize;
        }

    }

}

