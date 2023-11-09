package lotto.domain.lottoManage;

import lotto.domain.lotto.Lotto;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.GameConfig.LOTTO_PRICE;

public class LottoGenerator {

    private LottoGenerator() {

    }

    public static List<Lotto> generateWinningLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < calculatePurchasedLottoCount(purchaseAmount); i++) {
            winningLottos.add(generateWinningLotto());
        }
        return winningLottos;
    }

    private static Lotto generateWinningLotto() {
        return Lotto.create(RandomUtil.generateRandomLottoNumber());
    }

    private static int calculatePurchasedLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPrimitivePurchaseAmount() / LOTTO_PRICE.getNumber();
    }
}
