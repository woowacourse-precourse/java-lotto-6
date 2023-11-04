package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumberConstant.BUYING_PRICE_UNIT;
import static lotto.constant.NumberConstant.MIN_BUYING_AMOUNT;

public final class LottoGame {

    private final List<Lotto> lottos;
    private final int buyingAmount;
    private final int buyingPrice;

    private LottoGame(final List<Lotto> lottos, final int buyingAmount, final int buyingPrice) {
        this.lottos = lottos;
        this.buyingAmount = buyingAmount;
        this.buyingPrice = buyingPrice;
    }

    public static LottoGame createLottoGame(final int buyingPrice) {
        List<Lotto> lottos = new ArrayList<>();
        int buyingAmount = buyingPrice / BUYING_PRICE_UNIT;

        for (int i = MIN_BUYING_AMOUNT; i < buyingAmount; i++) {
            List<Integer> numbers = Lotto.pickUniqueNumbersInRange();
            Lotto lotto = Lotto.createLotto(numbers);
            lottos.add(lotto);
        }
        return new LottoGame(lottos, buyingAmount, buyingPrice);
    }

    public WinningResult calculateWinning(final WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            int correctAmount = lotto.calculateCorrectAmount(winningLotto);
            boolean bonusCorrect = lotto.calculateBonusCorrect(winningLotto);
            winningResult.winRank(correctAmount, bonusCorrect);
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
