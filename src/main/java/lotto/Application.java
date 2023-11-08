package lotto;

import static lotto.views.UserInput.readPurchasePrice;
import static lotto.views.UserOutput.askPurchasePrice;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;

public class Application {
    private static final LottoStore lottoStore = new LottoStore();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        askPurchasePrice();
        Integer purchasePrice = readPurchasePrice();

        List<Lotto> lottos = lottoStore.purchaseLotto(purchasePrice);
    }
}
