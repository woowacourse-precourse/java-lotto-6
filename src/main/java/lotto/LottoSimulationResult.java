package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulationResult {
    List<Integer> resultCount;

    public LottoSimulationResult() {
        this.resultCount = new ArrayList<>(LottoMatchResult.values().length);

        for (int i = 0; i < LottoMatchResult.values().length; i++) {
            resultCount.add(0);
        }
    }

    public void add(LottoMatchResult result) {
        int value = resultCount.get(result.getIndex());
        resultCount.set(value + 1, result.getIndex());
    }

    public float calculateReturn() {
        int totalAmount = 0, returnAmount = 0;

        for (LottoMatchResult matchResult : LottoMatchResult.values()) {
            totalAmount += LottoSimulator.LOTTO_PRICE;
            returnAmount += matchResult.getReward();
        }

        return (float)returnAmount / totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (LottoMatchResult matchResult : LottoMatchResult.values()) {
            if (matchResult == LottoMatchResult.UNMATCHED) {
                continue;
            }

            result.append(String.format("%s - %d개\n", matchResult, resultCount.get(matchResult.getIndex())));
        }
        result.append(String.format("총 수익률은 %.2f%%입니다.", calculateReturn() * 100));

        return result.toString();
    }
}
