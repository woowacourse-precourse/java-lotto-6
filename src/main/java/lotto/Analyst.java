package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Analyst {
    Map<LottoMessage, Integer> lottoResult = new LinkedHashMap<>();
    private final List<Lotto> lottos;
    private final List<Integer> winningLottoNumber;
    private final int bonusNumber;

    public Analyst(List<Lotto> lottos, List<Integer> winningLottoNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningLottoNumber = winningLottoNumber;
        this.bonusNumber = bonusNumber;

        lottoResult.put(LottoMessage.THREE, 0);
        lottoResult.put(LottoMessage.FOUR, 0);
        lottoResult.put(LottoMessage.FIVE, 0);
        lottoResult.put(LottoMessage.BONUS, 0);
        lottoResult.put(LottoMessage.SIX, 0);
    }

    public void calculate() {
        for (Lotto lotto : lottos) {
            List<Integer> winningNumbers = new ArrayList<>(lotto.getLottoNumbers());

            boolean isBonusNumber = winningNumbers.contains(bonusNumber);
            winningNumbers.retainAll(winningLottoNumber);

            rankCalculator(isBonusNumber, winningNumbers);
        }
    }

    private void rankCalculator(boolean isBonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.size() == 3) {
            lottoResult.put(LottoMessage.THREE, lottoResult.get(LottoMessage.THREE) + 1);
        }
        if (winningNumbers.size() == 4) {
            lottoResult.put(LottoMessage.FOUR, lottoResult.get(LottoMessage.FOUR) + 1);
        }
        if (winningNumbers.size() == 5 && !isBonusNumber) {
            lottoResult.put(LottoMessage.FIVE, lottoResult.get(LottoMessage.FIVE) + 1);
        }
        if (winningNumbers.size() == 5 && isBonusNumber) {
            lottoResult.put(LottoMessage.BONUS, lottoResult.get(LottoMessage.BONUS) + 1);
        }
        if (winningNumbers.size() == 6) {
            lottoResult.put(LottoMessage.SIX, lottoResult.get(LottoMessage.SIX) + 1);
        }
    }
}
