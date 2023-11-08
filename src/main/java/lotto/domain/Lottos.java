package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private final Player player;
    private final Map<LottoResult, Integer> lottoResultWithCount = new HashMap<>();
    private LottoResult lottoResult = LottoResult.NONE;
    private int total = 0;

    public Lottos(List<Integer> winningNumber, int bonusNumber, Player player) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.player = player;
    }

    public int classifyLottoGrade() {
        for (int i = 0; i < player.getLotteries().size(); i++) {
            int match = calculateMatchNumbers(i);
            if (match == 5 && isBonusNumberIncluded(i)) {
                match += 5;
            }
            this.lottoResult = LottoResult.initiateLottoResult(match);
            addCount(lottoResult);
            this.total += lottoResult.getGrade();
        }
        return this.total;
    }

    private void addCount(LottoResult lottoResult) {
        lottoResultWithCount.put(lottoResult, lottoResultWithCount.getOrDefault(lottoResult, 0) + 1);
    }

    public double calculateTotalRate() {
        return Math.round(((double) this.total / player.getAmount()) * 10000) / 100.0;
    }

    public Map<LottoResult, Integer> getLottoResultWithCount() {
        return this.lottoResultWithCount;
    }

    public int calculateMatchNumbers(int index) {
        int count = 0;
        List<Integer> lotto = player.getLotteries().get(index).getNumbers();
        for (Integer number : winningNumber) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonusNumberIncluded(int index) {
        return player.getLotteries().get(index).getNumbers().contains(bonusNumber);
    }
}
