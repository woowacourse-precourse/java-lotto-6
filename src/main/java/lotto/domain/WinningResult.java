package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> result;

    // 생성자
    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    // 특정 Rank(등수)의 당첨 횟수를 반환
    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    // 당첨금 총액을 계산하여 반환
    public int getTotalPrize() {
        double totalPrize = result.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return (int) totalPrize;
    }

    // 당첨 결과를 계산하여 WinningResult 객체를 반환
    public static WinningResult calculate(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = winningNumbers.calculateRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new WinningResult(result);
    }
}
