package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoGenerator generator;
    private final List<Lotto> purchasedLottos;
    public LottoMachine(LottoGenerator generator) {
        this.generator = generator;
        this.purchasedLottos = new ArrayList<>();
    }
    public void purchaseLottos(int numberOfLottos) {
        for (int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = generator.generate();
            purchasedLottos.add(lotto);
        }
    }
    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
    public LottoResults drawWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean hasBonus = lotto.contains(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);
            results.addResult(rank);
        }
        return results;
    }
}
