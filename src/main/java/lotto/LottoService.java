package lotto;

import lotto.domain.LottoShop;
import lotto.view.InputView;

public class LottoService {

    private final InputView inputView = new InputView();
    private final LottoShop lottoShop = new LottoShop();

    public void serviceStart() {
        int money = inputView.inputPurchaseAmount();
        int lottoCount = lottoShop.buyLotto(money);
    }

}
