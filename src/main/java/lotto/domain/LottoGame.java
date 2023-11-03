package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoGame {

    private final List<Lotto> lottos;
    private final int buyingAmount;

    private LottoGame(final List<Lotto> lottos, final int buyingAmount) {
        this.lottos = lottos;
        this.buyingAmount = buyingAmount;
    }

    public static LottoGame createLottoGame(final int buyingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyingAmount; i++) {
            List<Integer> numbers = Lotto.pickUniqueNumbersInRange();
            Lotto lotto = Lotto.createLotto(numbers);
            lottos.add(lotto);
        }
        return new LottoGame(lottos, buyingAmount);
    }

    public WinningResult calculateWinning(final WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            int correctAmount = lotto.calculateCorrectAmount(winningLotto);
            boolean bonusCorrect = lotto.calculateBonusCorrect(winningLotto);
            winningResult.winningRank(correctAmount, bonusCorrect);
        }

        return winningResult;
    }

    // getter
    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBuyingAmount() {
        return buyingAmount;
    }
}
