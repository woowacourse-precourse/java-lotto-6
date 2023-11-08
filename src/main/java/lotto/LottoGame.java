package lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public void start() {
        // TODO: 로또 구입 금액 입력
        // TODO: 발행한 로또 수량 및 번호 출력
        // TODO: 당첨 번호 입력
        // TODO: 보너스 번호 입력
        // TODO: 당첨 내역 출력
        // TODO: 수익률 출력
    }

    public HashMap<LottoRank, Integer> getWinningHistory(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<LottoRank, Integer> winningHistory = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningHistory.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusNumberHit = lotto.hasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.selectRankByMatchCount(matchCount, bonusNumberHit);
            winningHistory.put(rank, winningHistory.get(rank) + 1);
        }

        return winningHistory;
    }

    public double calculateProfitRateFromWinningHistory(int purchaseAmount, Map<LottoRank, Integer> winningHistory) {
        double profit = 0;
        for (LottoRank key : winningHistory.keySet()) {
            profit += winningHistory.get(key) * key.getPrizeMoney();
        }

        return (profit / purchaseAmount) * 100;
    }
}
