package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    private final List<Lotto> lottos;
    private final List<Integer> winningLotteryNumbers;
    private final int bonusNumber;

    public LottoChecker(List<Lotto> lottos, List<Integer> winningLotteryNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningLotteryNumbers = winningLotteryNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkResults() {
        Map<LottoRank, Integer> results = initializeResults();

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningLotteryNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        // 결과 출력 로직을 추가할 수 있습니다.
        // 예: 결과를 순회하면서 등수와 일치하는 로또의 수를 출력합니다.
        results.forEach((rank, count) -> {
            if (rank != LottoRank.NONE && count > 0) { // NONE은 당첨되지 않은 경우를 의미합니다.
                System.out.println(rank + ": " + count + "개");
            }
        });
    }

    private Map<LottoRank, Integer> initializeResults() {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
        return results;
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}
