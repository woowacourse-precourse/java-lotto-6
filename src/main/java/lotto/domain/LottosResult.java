package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottosResult {
    private static final String WINNING_STATISTICS_INFO_MESSAGE = "당첨 통계\n---\n";
    private final HashMap<Winner, Integer> result = new LinkedHashMap<>();
    private double rateOfReturn = 0.0;

    public LottosResult() {
        for (Winner winner : Winner.values()) {
            result.put(winner, 0);
        }
    }

    public Integer get(Winner key) {
        isKeyExist(key);
        return result.get(key);
    }

    public void put(Winner key, int value) {
        isKeyExist(key);
        result.put(key, value);
    }

    public void calculateRateOfReturn(int money) {
        rateOfReturn = (double) getLottoWinningMoney() / money * 100;
    }

    public int getLottoWinningMoney() {
        int totalMoney = 0;
        for (Map.Entry<Winner, Integer> entry : result.entrySet()) {
            totalMoney += entry.getKey().getWinningMoney() * entry.getValue();
        }
        return totalMoney;
    }

    private void isKeyExist(Winner key) {
        if (result.get(key) == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STATISTICS_INFO_MESSAGE);
        for (Map.Entry<Winner, Integer> entry : result.entrySet()) {
            sb.append(entry.getKey().toString()).append(" - ").append(entry.getValue()).append("개\n");
        }
        sb.append(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
        return sb.toString();
    }
}
