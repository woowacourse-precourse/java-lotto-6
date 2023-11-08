package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumberConstant.BUYING_PRICE_UNIT;
import static lotto.constant.NumberConstant.MIN_BUYING_AMOUNT;

public final class LottoGame {

    private final List<Lotto> lottos;
    private final int buyingAmount;

    private LottoGame(final List<Lotto> lottos, final int buyingAmount) {
        this.lottos = lottos;
        this.buyingAmount = buyingAmount;
    }

    public static LottoGame createLottoGame(final int buyingPrice) {
        List<Lotto> lottos = new ArrayList<>();
        int buyingAmount = calculateBuyingAmount(buyingPrice);

        for (int i = MIN_BUYING_AMOUNT; i < buyingAmount; i++) {
            List<Integer> numbers = Lotto.pickUniqueNumbersInRange();
            Lotto lotto = Lotto.createLotto(numbers);
            lottos.add(lotto);
        }
        return new LottoGame(lottos, buyingAmount);
    }

    private static int calculateBuyingAmount(final int buyingPrice) {
        return buyingPrice / BUYING_PRICE_UNIT;
    }

    public WinningResult calculateWinning(final WinningLotto winningLotto) {
        WinningResult winningResult = WinningResult.create();
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
