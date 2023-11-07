package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();

    public void run() {
        Integer purchaseAmount = InputView.inputPurchaseAmount();
        createLottos(purchaseAmount);

    }

    private void createLottos(Integer purchaseAmount) {
        System.out.println("\n" + purchaseAmount /1000 + "개를 구매했습니다.");
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.run());
            lottos.add(lotto);
        }
    }

}
