package lotto.model;

import java.util.List;

import static lotto.model.constant.LottoConfig.ZERO;

public class LottoResult {

    private Purchase purchase;
    private WinningNumbers winningNumbers;

    public LottoResult(Purchase purchase, WinningNumbers winningNumbers) {
        this.purchase = purchase;
        this.winningNumbers = winningNumbers;
    }

    public int[] calculateRank() {
        List<Lotto> lottos = purchase.getLottos();
        int[] result = new int[7];
        for (Lotto lotto : lottos) {
            PriceMoney rank = winningNumbers.calculate(lotto);
            result[rank.ordinal()]++;
        }
        return result;
    }

    public Integer calculatePriceSum() {
        Integer sum = ZERO;

        List<Lotto> lottos = purchase.getLottos();
        for (Lotto lotto : lottos) {
            PriceMoney rank = winningNumbers.calculate(lotto);
            sum += PriceMoney.getPrice(rank);
        }
        return sum;
    }
}
